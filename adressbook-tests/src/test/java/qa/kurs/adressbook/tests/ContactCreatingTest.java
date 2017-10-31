package qa.kurs.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.kurs.adressbook.model.ContactData;

import java.util.Set;

public class ContactCreatingTest extends TestBase {


  @Test
  public void testContactCreation() {

    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withFirstName("testowy1").withLastName("test1").withGroup("test1");
    app.goTo().createContact();
    app.contact().fillContactForm(contact, true);
    app.contact().submitContact();
    app.goTo().contactPage();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);

  }


}
