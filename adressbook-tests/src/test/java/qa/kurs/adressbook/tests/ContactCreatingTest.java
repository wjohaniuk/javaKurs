package qa.kurs.adressbook.tests;

import org.testng.annotations.Test;
import qa.kurs.adressbook.model.ContactData;

public class ContactCreatingTest extends TestBase{
    

    @Test
    public void testContactCreation() {
        app.gotoCreateContact();
        app.fillContactForm(new ContactData("testowy", "tester", "test", "test123", "testowa"));
        app.submitContact();
    }


}
