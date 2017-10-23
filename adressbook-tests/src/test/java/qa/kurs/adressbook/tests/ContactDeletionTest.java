package qa.kurs.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.kurs.adressbook.model.ContactData;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() {

    app.getNavigationHelper().goToContactPage();
    int befor = app.getContactHelper().getContactCount();
    if (!app.getContactHelper().isThereContact()) {
      app.getNavigationHelper().gotoCreateContact();
      app.getContactHelper().createContact(new ContactData("testowy", "tester",
              "test", null, "test", "test1"), true);
    }
    app.getNavigationHelper().goToContactPage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().alertAccept();
    app.getNavigationHelper().goToContactPage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, befor - 1);
  }


}
