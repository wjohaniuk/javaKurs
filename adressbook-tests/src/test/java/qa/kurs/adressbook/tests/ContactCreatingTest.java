package qa.kurs.adressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qa.kurs.adressbook.model.ContactData;
import qa.kurs.adressbook.model.Contacts;
import qa.kurs.adressbook.model.GroupData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreatingTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
        String xml ="";
        String line = reader.readLine();
        while (line != null){
            xml += line;
            line = reader.readLine();
        }
        XStream xstream = new XStream();
        xstream.processAnnotations(ContactData.class);
        List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
        return contacts.stream().map((g)-> new Object[] {g}).collect(Collectors.toList()).iterator();
    }

    @Test(dataProvider = "validContacts")
    public void testContactCreation(ContactData contact) {

        Contacts before = app.contact().all();
        File photo =  new File("src/test/resources/orzel_grafika.jpg");

        app.goTo().createContact();
        app.contact().fillContactForm(contact, true);
        app.contact().submitContact();
        app.goTo().contactPage();
        assertThat(app.contact().Count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();



        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

    }
}
