package qa.kurs.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.kurs.adressbook.model.ContactData;

import java.util.Set;

public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().all().size() == 0) {
      app.goTo().createContact();
      app.contact().createContact(new ContactData().withFirstName("testowy1").withMiddleName("tester")
              .withLastName("test2").withNickName("test").withCompany("test1").withGroup("test1"), true);
    }
  }

  @Test
  public void testContactDeletion() {
    app.goTo().contactPage();
    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedContact);
    Assert.assertEquals(before, after);
  }


}
