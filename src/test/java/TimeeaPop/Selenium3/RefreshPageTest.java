package TimeeaPop.Selenium3;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

public class RefreshPageTest extends BasePageObjectS3 {
    WebDriver driver;
    RefreshPageObject refreshPageObject;

    @BeforeTest
    public void initialize() throws MalformedURLException {
        driver = getChromeDriver();
        //driver = getRemoteDriver();
        refreshPageObject = new RefreshPageObject(driver);
    }
    @AfterTest
    public void endTest() {
        driver.quit();
    }

    @Test
    public void refreshPageAndConvertTimestampToCurrentTimeAndDate() throws IOException {
        try {
            refreshPageObject.landOnRefreshPage();
            refreshPageObject.convertTimestampToCurrentTimeAndDate();
        } catch (Exception e) {
            refreshPageObject.takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }
}
