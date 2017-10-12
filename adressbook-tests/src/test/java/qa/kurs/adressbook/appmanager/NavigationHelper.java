package qa.kurs.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase{


  public NavigationHelper(WebDriver wd) {
   super (wd);
  }

  public void gotoCreateContact() {
    click(By.linkText("add new"));
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }

  public void goToContactPage() {
    click(By.linkText("home"));
  }
}
