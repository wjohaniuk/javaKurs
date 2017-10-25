package qa.kurs.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.kurs.adressbook.model.ContactData;
import qa.kurs.adressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreatingTest extends TestBase {


  @Test
  public void testContactCreation() {

    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("testowy1", "tester",
            "test2", null, "test", "test1");
    app.getNavigationHelper().gotoCreateContact();
    app.getContactHelper().fillContactForm(contact, true);
    app.getContactHelper().submitContact();
    app.getNavigationHelper().goToContactPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);


    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);

    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }


}
