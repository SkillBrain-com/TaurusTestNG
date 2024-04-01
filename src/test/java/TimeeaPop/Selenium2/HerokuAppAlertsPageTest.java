package TimeeaPop.Selenium2;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class HerokuAppAlertsPageTest extends BasePageObject {
    WebDriver driver;
    HerokuAppAlertsPageObject herokuAppAlertsPageObject;

    @BeforeTest
    public void initialize() {
        driver = getChromeDriver();
        herokuAppAlertsPageObject = new HerokuAppAlertsPageObject(driver);
    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }

    @Test
    public void clickOnShowAlertBoxButton() throws IOException {
        try {
            herokuAppAlertsPageObject.landOnAlexBoxExamplePage();
            herokuAppAlertsPageObject.clickOnShowAlertBoxButton();
            herokuAppAlertsPageObject.checkFirstAlertAndCloseIt();
        } catch (Exception e) {
            herokuAppAlertsPageObject.takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void clickOnConfirmAlertAndAcceptIt() throws IOException{
        try {
            herokuAppAlertsPageObject.landOnAlexBoxExamplePage();
            herokuAppAlertsPageObject.clickOnShowConfirmBoxButton();
            herokuAppAlertsPageObject.acceptConfirmAlertAndCloseIt();
        } catch (Exception e) {
            herokuAppAlertsPageObject.takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void clickOnConfirmAlertAndCancelIt() throws IOException{
        try {
            herokuAppAlertsPageObject.landOnAlexBoxExamplePage();
            herokuAppAlertsPageObject.clickOnShowConfirmBoxButton();
            herokuAppAlertsPageObject.cancelConfirmAlertAndCloseIt();
        } catch (Exception e) {
            herokuAppAlertsPageObject.takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void dismissPromptAlert() throws IOException {
        try{
            herokuAppAlertsPageObject.landOnAlexBoxExamplePage();
            herokuAppAlertsPageObject.clickOnShowPromptBox();
            herokuAppAlertsPageObject.dismissPromptAlert();
        } catch (Exception e) {
            herokuAppAlertsPageObject.takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void addNewTextToPromptAlertAndConfirmIt() throws IOException {
        try{
            scrollToBottom();
            herokuAppAlertsPageObject.landOnAlexBoxExamplePage();
            herokuAppAlertsPageObject.clickOnShowPromptBox();
            herokuAppAlertsPageObject.changePromptAlertTextAndConfirm();
        } catch (Exception e) {
            herokuAppAlertsPageObject.takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }
}
