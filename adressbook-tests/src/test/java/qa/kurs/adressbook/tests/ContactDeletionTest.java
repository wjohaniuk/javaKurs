package qa.kurs.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.kurs.adressbook.model.ContactData;
import qa.kurs.adressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      if (app.contact().all().size() == 0) {
        app.goTo().createContact();
        app.contact().createContact(new ContactData().withFirstName("testowy1").withMiddleName("tester")
                .withLastName("test2").withNickName("test").withCompany("test1").withGroup("test1"), true);
      }
    }
  }

  @Test
  public void testContactDeletion() {
    app.goTo().contactPage();
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    assertThat(app.contact().Count(), equalTo(before.size() - 1));
    Contacts after = app.db().contacts();

    assertThat(after, equalTo(before.without(deletedContact)));

  }


}
