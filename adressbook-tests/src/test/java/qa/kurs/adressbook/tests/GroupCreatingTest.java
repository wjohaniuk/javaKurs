package qa.kurs.adressbook.tests;

import org.testng.annotations.Test;
import qa.kurs.adressbook.model.GroupData;


public class GroupCreatingTest extends TestBase {

  @Test
  public void testGroupCreation() {

    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returntoGroupPage();
  }

}
