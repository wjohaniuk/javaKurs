package qa.kurs.adressbook.tests;

import org.testng.annotations.Test;
import qa.kurs.adressbook.model.ContactData;
import qa.kurs.adressbook.model.GroupData;

public class ContactEditionTest extends TestBase {


    @Test
    public void testContactModification() {
        app.getNavigationHelper().goToContactPage();
        app.getContactHelper().initCotactModification();
        app.getContactHelper().fillContactForm(new ContactData("testowy", "tester", "test", "test123", "testowa"));
        app.getContactHelper().submitContactModification();


    }
}