package qa.kurs.adressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletingTest extends TestBase {


  @Test
  public void testGroupDeleting() {

    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroup();
    app.getGroupHelper().returntoGroupPage();
  }

}
