package qa.kurs.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.kurs.adressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTest extends TestBase {


  @Test
  public void testGroupDeletion() {

    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(0);
    app.getGroupHelper().deleteSelectedGroup();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() - 1);
  }


}
