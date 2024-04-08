package TimeeaPop.TestNG721Test;

import TestNG721.BasePageObject;
import TestNG721.KatalonMainPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

public class KatalonMainPageTest extends BasePageObject {
    WebDriver driver;
    KatalonMainPageObject katalonMainPageObject;

    @BeforeTest
    public void initialize() throws MalformedURLException {
        //driver = getChromeDriver();
        driver = getRemoteDriver();
        katalonMainPageObject = new KatalonMainPageObject(driver);
    }
    @AfterTest
    public void endTest() {
        driver.quit();
    }

    @Test
    public void landOnLoginPage() throws IOException {
        try{
            katalonMainPageObject.landOnMainPage();
            katalonMainPageObject.clickOnMenuButton();
            katalonMainPageObject.clickOnLoginButton();
        } catch (Exception e) {
            katalonMainPageObject.takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void makeAppointmentWithoutLogginIn() throws IOException {
        try {
            katalonMainPageObject.landOnMainPage();
            katalonMainPageObject.clickOnMakeAppointmentButton();
            System.out.println(driver.getCurrentUrl());
        } catch (Exception e) {
            katalonMainPageObject.takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }
}
