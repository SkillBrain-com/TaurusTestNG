package TimeeaPop.Selenium2;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

public class HerokuAppFakeAlertsPageTest extends BasePageObject {
    WebDriver driver;
    HerokuAppFakeAlertsPageObject herokuAppFakeAlertsPageObject;
    @BeforeTest
    public void initialize() throws MalformedURLException {
        driver = getRemoteDriver();
        herokuAppFakeAlertsPageObject = new HerokuAppFakeAlertsPageObject(driver);
    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }

    @Test
    public void showFakeAlertBox() throws IOException {
        try {
            herokuAppFakeAlertsPageObject.landOnFakeAlertsPage();
            herokuAppFakeAlertsPageObject.clickOnFakeAlertButton();
            herokuAppFakeAlertsPageObject.checkFakeDialogAndCloseIt();
        } catch (Exception e) {
            herokuAppFakeAlertsPageObject.takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void showModalDialogButton() throws IOException {
        try {
            herokuAppFakeAlertsPageObject.landOnFakeAlertsPage();
            herokuAppFakeAlertsPageObject.clickOnShowModalDialogButton();
            herokuAppFakeAlertsPageObject.checkFakeDialogAndCloseIt();
        } catch (Exception e) {
            herokuAppFakeAlertsPageObject.takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }
}
