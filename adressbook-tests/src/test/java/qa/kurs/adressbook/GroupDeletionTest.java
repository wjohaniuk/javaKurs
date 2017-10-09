package qa.kurs.adressbook;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase{



    @Test
    public void testGroupDeletion() {
        gotoGroupPage();
        selectGroup();
        deleteSelectedGroup();
        returntoGroupPage();    }


}
