package qa.kurs.adressbook.tests;

import org.testng.annotations.Test;
import qa.kurs.adressbook.model.ContactData;

public class ContactCreatingTest extends TestBase {


  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoCreateContact();
    app.getContactHelper().fillContactForm(new ContactData("testowy", "tester", "test", null, null));
    app.getContactHelper().submitContact();
  }


}
