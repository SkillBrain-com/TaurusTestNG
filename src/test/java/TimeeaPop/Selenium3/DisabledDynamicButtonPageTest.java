package TimeeaPop.Selenium3;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

public class DisabledDynamicButtonPageTest extends BasePageObjectS3 {
    WebDriver driver;
    DisabledDynamicButtonPageObject disabledDynamicButtonPageObject;
    @BeforeTest
    public void initialize() throws MalformedURLException {
        driver = getChromeDriver();
        //driver = getRemoteDriver();
        disabledDynamicButtonPageObject = new DisabledDynamicButtonPageObject(driver);
    }
    @AfterTest
    public void endTest() {
        driver.quit();
    }

    @Test
    public void clickOnAllButtons() throws IOException {
        try {
            disabledDynamicButtonPageObject.landOnDisableDynamicButtonPage();
            disabledDynamicButtonPageObject.clickOnStartButton();
            disabledDynamicButtonPageObject.clickOnButtonNumberOne();
            disabledDynamicButtonPageObject.clickOnButtonNumberTwo();
            disabledDynamicButtonPageObject.clickOnButtonNumberThree();
            disabledDynamicButtonPageObject.successMessageIsDisplayed();
        } catch (Exception e) {
            disabledDynamicButtonPageObject.takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }
}
