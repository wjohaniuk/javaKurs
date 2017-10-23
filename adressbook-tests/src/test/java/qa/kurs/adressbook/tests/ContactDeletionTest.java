package qa.kurs.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.kurs.adressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() {


    if (!app.getContactHelper().isThereContact()) {
      app.getNavigationHelper().gotoCreateContact();
      app.getContactHelper().createContact(new ContactData("testowy", "tester",
              "test", null, "test", "test1"), true);
    }
    app.getNavigationHelper().goToContactPage();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(0);
    app.getContactHelper().deleteContact();
    app.getContactHelper().alertAccept();
    app.getNavigationHelper().goToContactPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size()-1);
  }


}
