package qa.kurs.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.kurs.adressbook.model.ContactData;

import java.util.Set;

public class ContactEditionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().all().size() == 0) {
      app.goTo().createContact();
      app.contact().createContact(new ContactData().withFirstName("testowy1").withMiddleName("tester")
              .withLastName("test2").withNickName("test").withCompany("test1").withGroup("test1"), true);
    }
  }

  @Test
  public void testContactModification() {
    app.goTo().contactPage();
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("testowy1").withMiddleName("tester")
            .withLastName("test2").withGroup("test1");
    app.contact().modify(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);


  }

}