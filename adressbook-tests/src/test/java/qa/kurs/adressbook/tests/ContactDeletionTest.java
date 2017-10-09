package qa.kurs.adressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase{

    @Test
    public void testContactDeletion() {

        app.goToContactPage();
        app.selectContact();
        app.deleteContact();
        app.alertAccept();
        app.goToContactPage();
    }


}
