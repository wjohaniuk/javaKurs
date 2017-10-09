package qa.kurs.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper extends HelperBase{


  public SessionHelper(FirefoxDriver wd) {
    super (wd);
  }

  protected void login(String password, String login) {
    type(By.name("user"),login);
    type(By.name("pass"), password);
    click(By.xpath("//form[@id='LoginForm']/input[3]"));
  }
}
