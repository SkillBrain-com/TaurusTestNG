package TimeeaPop.TestNG721Test;

import TestNG721.BasePageObject;
import TestNG721.KatalonLoginPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

public class KatalonLoginPageTest extends BasePageObject {
    WebDriver driver;
    KatalonLoginPageObject katalonLoginPageObject;
    @BeforeTest
    public void initialize() throws MalformedURLException {
       driver = getChromeDriver();
        //driver = getRemoteDriver();
        katalonLoginPageObject = new KatalonLoginPageObject(driver);
    }
    @AfterTest
    public void endTest() {
        driver.quit();
    }

    @Test
    public void enterInvalidUsernameAndPassword() throws IOException {
        try {
            katalonLoginPageObject.landOnLoginPage();
            katalonLoginPageObject.addInvalidUsername();
            katalonLoginPageObject.addInvalidPassword();
            katalonLoginPageObject.clickOnLoginButton();
            System.out.println(driver.getCurrentUrl());
        } catch (Exception e) {
            katalonLoginPageObject.takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void loginWithValidUsernameAndPassword() throws IOException {
        try {
            katalonLoginPageObject.landOnLoginPage();
            katalonLoginPageObject.addValidUsername();
            katalonLoginPageObject.addValidPassword();
            katalonLoginPageObject.clickOnLoginButton();
            System.out.println(driver.getCurrentUrl());
        } catch (Exception e) {
            katalonLoginPageObject.takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void createAnAppointmentSuccessfully() throws IOException {
        try {
            katalonLoginPageObject.landOnLoginPage();
            katalonLoginPageObject.addValidUsername();
            katalonLoginPageObject.addValidPassword();
            katalonLoginPageObject.clickOnLoginButton();
            katalonLoginPageObject.chooseFacility();
            katalonLoginPageObject.chooseMedicaidHealthcareProgram();
            katalonLoginPageObject.selectDateForAppointment();
            katalonLoginPageObject.addAdditionalCommentForAppointment();
            katalonLoginPageObject.clickOnBookAppointmentButton();
            System.out.println(driver.getCurrentUrl());
            katalonLoginPageObject.checkConfirmationMessageTitle();
            katalonLoginPageObject.takeScreenshot(driver);
        } catch (Exception e) {
            katalonLoginPageObject.takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void createInvalidAppointment() throws IOException {
        try {
            katalonLoginPageObject.landOnLoginPage();
            katalonLoginPageObject.addValidUsername();
            katalonLoginPageObject.addValidPassword();
            katalonLoginPageObject.clickOnLoginButton();
            katalonLoginPageObject.chooseFacility();
            katalonLoginPageObject.chooseMedicaidHealthcareProgram();
            //katalonLoginPageObject.selectDateForAppointment();
            katalonLoginPageObject.addAdditionalCommentForAppointment();
            katalonLoginPageObject.clickOnBookAppointmentButton();
            katalonLoginPageObject.checkIfAlertIsDisplayedIfDateIsNotSelected();
//            System.out.println(driver.getCurrentUrl());
//            katalonLoginPageObject.checkConfirmationMessageTitle();
            katalonLoginPageObject.takeScreenshot(driver);
        } catch (Exception e) {
            katalonLoginPageObject.takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void navigateToHomePageAfterBookingInvalidAppointment() throws IOException {
        try {
            katalonLoginPageObject.landOnLoginPage();
            katalonLoginPageObject.addValidUsername();
            katalonLoginPageObject.addValidPassword();
            katalonLoginPageObject.clickOnLoginButton();
            katalonLoginPageObject.chooseFacility();
            katalonLoginPageObject.chooseMedicaidHealthcareProgram();
            //katalonLoginPageObject.selectDateForAppointment();
            katalonLoginPageObject.addAdditionalCommentForAppointment();
            katalonLoginPageObject.clickOnBookAppointmentButton();
            katalonLoginPageObject.checkIfAlertIsDisplayedIfDateIsNotSelected();
//            System.out.println(driver.getCurrentUrl());
//            katalonLoginPageObject.checkConfirmationMessageTitle();
            katalonLoginPageObject.takeScreenshot(driver);
            katalonLoginPageObject.clickOnMainMenuButton();
            katalonLoginPageObject.clickOnHomeButton();
            System.out.println(driver.getCurrentUrl());
            katalonLoginPageObject.takeScreenshot(driver);
        } catch(Exception e) {
            katalonLoginPageObject.takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }

}
