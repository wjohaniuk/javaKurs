package qa.kurs.adressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase{



    @Test
    public void testGroupDeletion() {
        app.gotoGroupPage();
        app.selectGroup();
        app.deleteSelectedGroup();
        app.returnToGroupPage();    }


}
