package qa.kurs.adressbook.tests;

import org.testng.annotations.Test;
import qa.kurs.adressbook.model.ContactData;
import qa.kurs.adressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreatingTest extends TestBase {


    @Test
    public void testContactCreation() {

        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withFirstName("testowy1").withLastName("test1").withGroup("test1");
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
