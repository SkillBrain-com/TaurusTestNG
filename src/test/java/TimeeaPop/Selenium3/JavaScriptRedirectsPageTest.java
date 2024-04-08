package TimeeaPop.Selenium3;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

public class JavaScriptRedirectsPageTest extends BasePageObjectS3 {
    WebDriver driver;
    JavaScriptRedirectsPageObject javaScriptRedirectsPageObject;
    @BeforeTest
    public void initialize() throws MalformedURLException {
        driver = getChromeDriver();
        //driver = getRemoteDriver();
        javaScriptRedirectsPageObject = new JavaScriptRedirectsPageObject(driver);
    }
    @AfterTest
    public void endTest() {
        driver.quit();
    }

    @Test
    public void clickOnFiveSecondsRedirectButton() throws IOException {
        try {
            javaScriptRedirectsPageObject.landOnJavaScriptRedirectsPage();
            javaScriptRedirectsPageObject.clickOnFiveSecondsRedirectButton();
            Thread.sleep(6000);
            javaScriptRedirectsPageObject.checkCurrentURL();
            javaScriptRedirectsPageObject.checkTitleFromRedirectedPage();
            javaScriptRedirectsPageObject.checkSuccessMessageFromRedirectedPage();
        } catch (Exception e) {
            javaScriptRedirectsPageObject.takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void clickOnTwoSecondsRedirectButton() throws IOException{
        try {
            javaScriptRedirectsPageObject.landOnJavaScriptRedirectsPage();
            javaScriptRedirectsPageObject.clickOnTwoSecondsRedirectButton();
            Thread.sleep(3000);
            javaScriptRedirectsPageObject.checkCurrentURL();
            javaScriptRedirectsPageObject.checkTitleFromRedirectedPage();
            javaScriptRedirectsPageObject.checkSuccessMessageFromRedirectedPage();
        } catch (Exception e) {
            javaScriptRedirectsPageObject.takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }
}
