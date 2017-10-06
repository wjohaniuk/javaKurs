package qa.kurs.adressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import qa.kurs.adressbook.appmanager.AppManager;

public class TestBase {

  protected final AppManager app = new AppManager();

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }

}
