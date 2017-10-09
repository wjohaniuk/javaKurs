package qa.kurs.adressbook;

import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase{

    @Test
    public void testContactDeletion() {

        goToContactPage();
        selectContact();
        deleteContact();
        alertAccept();
        goToContactPage();
    }


}
