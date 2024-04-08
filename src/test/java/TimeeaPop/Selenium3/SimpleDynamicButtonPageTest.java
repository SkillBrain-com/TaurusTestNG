package TimeeaPop.Selenium3;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

public class SimpleDynamicButtonPageTest extends BasePageObjectS3 {
    WebDriver driver;
    SimpleDynamicButtonPageObject simpleDynamicButtonPageObject;
    @BeforeTest
    public void initialize() throws MalformedURLException {
        driver = getChromeDriver();
        //driver = getRemoteDriver();
        simpleDynamicButtonPageObject = new SimpleDynamicButtonPageObject(driver);
    }
    @AfterTest
    public void endTest() {
        driver.quit();
    }

    @Test
    public void clickOnAllButtons() throws IOException {
        try {
            simpleDynamicButtonPageObject.landOnSimpleDynamicButtonPage();
            simpleDynamicButtonPageObject.clickOnStartButton();
            simpleDynamicButtonPageObject.clickOnButtonNumberOne();
            simpleDynamicButtonPageObject.clickOnButtonNumberTwo();
            simpleDynamicButtonPageObject.clickOnButtonNumberThree();
            simpleDynamicButtonPageObject.successMessageIsDisplayed();
        } catch (Exception e) {
            simpleDynamicButtonPageObject.takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }
}
