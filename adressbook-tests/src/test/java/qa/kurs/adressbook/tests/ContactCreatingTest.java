package qa.kurs.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.kurs.adressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreatingTest extends TestBase {


  @Test
  public void testContactCreation() {

    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData().withFirstName("testowy1").withLastName("test1").withMiddleName("test");
    app.goTo().createContact();
    app.contact().fillContactForm(contact, true);
    app.contact().submitContact();
    app.goTo().contactPage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);



    before.add(contact);

    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }


}
