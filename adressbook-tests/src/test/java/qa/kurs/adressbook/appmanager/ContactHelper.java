package qa.kurs.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import qa.kurs.adressbook.model.ContactData;

public class ContactHelper extends HelperBase {

    protected GroupHelper groupHelper;

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContact() {
        click(By.name("submit"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getMiddleName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("nickname"), contactData.getNickName());
        type(By.name("company"), contactData.getCompany());
    }

    public void deleteContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void selectContact() {
        click(By.id("3"));
    }

    public void alertAccept() {
        wd.switchTo().alert().accept();
    }

    public void initContactModification() {
        click(By.xpath("//tr[@name='entry'][1]//td[@class='center'][3]"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }
}
