package qa.kurs.adressbook.tests;

import org.testng.annotations.Test;
import qa.kurs.adressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDetailsTest extends TestBase {

    @Test
    public void testContactDetails(){
        app.goTo().contactPage();
        app.contact().detailsPage(50);
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAllEmails(), equalTo(mergeDetails(contactInfoFromEditForm)));
    }

    private String mergeDetails(ContactData contact) {
        return Arrays.asList(contact.getEmail1(), contact.getEmail2(), contact.getEmail3(), contact.getFirstName(),
                contact.getCompany(),contact.getPersonalAddress(), contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone(),
                contact.getTitle(), contact.getMiddleName(),contact.getLastName(), contact.getNickName()).stream().filter((s) -> ! s.equals("") )
                .map(ContactDetailsTest::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String details) {
        return details.replaceAll("\\s","").replaceAll("[-()]","");
    }
}
