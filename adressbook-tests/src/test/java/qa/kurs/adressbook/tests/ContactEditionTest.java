package qa.kurs.adressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.kurs.adressbook.model.ContactData;
import qa.kurs.adressbook.model.Contacts;

import static org.testng.Assert.assertEquals;

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
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("testowy1").withMiddleName("tester")
            .withLastName("test2").withGroup("test1");
    app.contact().modify(contact);
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size());

    MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.without(modifiedContact).withAdded(contact)));


  }

}