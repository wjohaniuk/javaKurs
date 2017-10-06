package qa.kurs.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import qa.kurs.adressbook.model.GroupData;

public class GroupHelper extends HelperBase{

  public GroupHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void returntoGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectedGroup() {
    click(By.xpath("//div[@id='content']/form/input[5]"));
  }

  public void selectGroup() {
    click(By.xpath("//div[@id='content']/form/span[3]/input"));
  }
}
