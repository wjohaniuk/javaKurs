package qa.kurs.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.kurs.adressbook.model.ContactData;
import qa.kurs.adressbook.model.GroupData;

import java.util.List;

public class ContactCreatingTest extends TestBase {


  @Test
  public void testContactCreation() {

    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().gotoCreateContact();
    app.getContactHelper().fillContactForm(new ContactData("testowy", "tester",
            "test", null, "test", "test1"), true);
    app.getContactHelper().submitContact();
    app.getNavigationHelper().goToContactPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() +1);

  }


}
