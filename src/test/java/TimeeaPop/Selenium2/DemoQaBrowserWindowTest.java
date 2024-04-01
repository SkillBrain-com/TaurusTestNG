package TimeeaPop.Selenium2;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

public class DemoQaBrowserWindowTest extends BasePageObject {
    RemoteWebDriver driver;
    DemoQaBrowserWindowsPageObject demoQaBrowserWindowsPageObject;


    @BeforeTest
    public void initialize() throws MalformedURLException {
       // driver = getChromeDriver();
        driver = getRemoteDriver();
        demoQaBrowserWindowsPageObject = new DemoQaBrowserWindowsPageObject(driver);
    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }

    @Test
    public void accessNewTab() throws IOException {
        try {
            demoQaBrowserWindowsPageObject.landOnDemoqaBrowserWindowPage();
            demoQaBrowserWindowsPageObject.clickOnNewTabButton();
            demoQaBrowserWindowsPageObject.getHeadingFromNewTab();
        } catch (Exception e){
            demoQaBrowserWindowsPageObject.takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }

    }

    @Test(dependsOnMethods = "accessNewTab")
    public void accessNewWindow() throws IOException {
        demoQaBrowserWindowsPageObject.scrollToBottom();
        try {
            demoQaBrowserWindowsPageObject.landOnDemoqaBrowserWindowPage();
            demoQaBrowserWindowsPageObject.clickOnNewWindowButton();
            demoQaBrowserWindowsPageObject.getHeadingFromNewWindow();
            demoQaBrowserWindowsPageObject.takeScreenshot(driver);
        } catch (Exception e){
            demoQaBrowserWindowsPageObject.takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void getTextFromNewWindow() throws IOException {
        try {
            demoQaBrowserWindowsPageObject.landOnDemoqaBrowserWindowPage();
            demoQaBrowserWindowsPageObject.clickOnNewWindowMessageButton();
            demoQaBrowserWindowsPageObject.getMessageFromNewWindow();
            demoQaBrowserWindowsPageObject.takeScreenshot(driver);
        } catch (Exception e){
            demoQaBrowserWindowsPageObject.takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }

}
