package qa.kurs.adressbook.tests;

import org.testng.annotations.Test;
import qa.kurs.adressbook.model.ContactData;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactAddressTests extends TestBase {

    @Test
    public void testContactAddress() {
        app.goTo().contactPage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(cleanedPersonalAddress(contact.getPersonalAddress()), equalTo(cleanedPersonalAddress((contactInfoFromEditForm.getPersonalAddress()))));

    }

    public static String cleanedPersonalAddress(String personalAddress) {
        return personalAddress.replaceAll("\\s", "").replaceAll("\\n", "");
    }
}
