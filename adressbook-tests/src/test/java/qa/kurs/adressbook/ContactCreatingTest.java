package qa.kurs.adressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ContactCreatingTest extends TestBase{
    

    @Test
    public void testContactCreation() {
        gotoCreateContact();
        fillContactForm(new ContactData("testowy", "tester", "test", "test123", "testowa"));
        submitContact();
    }


}
