package qa.kurs.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.kurs.adressbook.model.ContactData;

import java.util.List;

public class ContactEditionTest extends TestBase {


    @Test
    public void testContactModification() {


        if (! app.getContactHelper().isThereContact()){
            app.getNavigationHelper().gotoCreateContact();
            app.getContactHelper().createContact(new ContactData("testowy", "tester",
                    "test", null, "test", "test1"), true);
        }
        app.getNavigationHelper().goToContactPage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactModification(0);
        app.getContactHelper().fillContactForm(new ContactData("testowy", "tester", "test", "test123", "testowa", null), false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().goToContactPage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());


    }
}