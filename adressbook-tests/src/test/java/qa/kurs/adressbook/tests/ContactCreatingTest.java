package qa.kurs.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.kurs.adressbook.model.ContactData;

public class ContactCreatingTest extends TestBase {


  @Test
  public void testContactCreation() {

    int befor = app.getContactHelper().getContactCount();
    app.getNavigationHelper().gotoCreateContact();
    app.getContactHelper().fillContactForm(new ContactData("testowy", "tester",
            "test", null, "test", "test1"), true);
    app.getContactHelper().submitContact();
    app.getNavigationHelper().goToContactPage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, befor +1);

  }


}
