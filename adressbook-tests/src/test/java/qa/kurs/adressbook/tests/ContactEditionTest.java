package qa.kurs.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.kurs.adressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactEditionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    if (app.group().list().size() == 0) {
      app.goTo().createContact();
      app.contact().createContact(new ContactData().withFirstName("testowy1").withMiddleName("tester")
              .withLastName("test2").withNickName("test").withCompany("test1"), true);
    }
  }

  @Test
  public void testContactModification() {
    app.goTo().contactPage();
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    ContactData contact = new ContactData().withId(before.get(index).getId()).withFirstName("testowy1").withMiddleName("tester")
            .withLastName("test2");
    app.contact().modify(index, contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);


  }

}