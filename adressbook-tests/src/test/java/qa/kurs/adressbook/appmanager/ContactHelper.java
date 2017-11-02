package qa.kurs.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import qa.kurs.adressbook.model.ContactData;
import qa.kurs.adressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {

    protected GroupHelper groupHelper;

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContact() {
        click(By.name("submit"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getMiddleName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("nickname"), contactData.getNickName());
        type(By.name("company"), contactData.getCompany());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

    }

    public void deleteContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void alertAccept() {
        wd.switchTo().alert().accept();
    }

    public void returnToContactPage() {
        click(By.linkText("home"));
    }

    private void initContactModificationById(int id) {
        wd.findElement(By.xpath(".//*[@id='" + id + "']//parent::td//parent::tr/td[8]//img")).click();
    }

    public void submitContactModification() {
        click(By.name("update"));
    }


    public void createContact(ContactData contact, boolean creation) {

        fillContactForm(contact, creation);
        submitContact();
    }

    public void modify(ContactData contact) {
        initContactModificationById(contact.getId());
        fillContactForm(contact, false);
        submitContactModification();
        returnToContactPage();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteContact();
        alertAccept();
        returnToContactPage();
    }

    public boolean isThereContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int Count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> rows = wd.findElements(By.name("entry"));

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            String firstName = row.findElement(By.xpath(".//td[3]")).getText();
            String lastName = row.findElement(By.xpath(".//td[2]")).getText();
            String[] phones = cells.get(5).getText().split("\n");
            int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName).
                    withHomePhone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2]));
        }
        return contacts;
    }


    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
    }
}
