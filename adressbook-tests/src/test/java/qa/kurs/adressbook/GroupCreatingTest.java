package qa.kurs.adressbook;

import org.testng.annotations.Test;

public class GroupCreatingTest extends TestBase{

  @Test
  public void testGroupCreation() {

    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("test1", "test2", "test3"));
    submitGroupCreation();
    returntoGroupPage();
  }

}
