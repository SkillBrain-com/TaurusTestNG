package CarmenOltean;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.skillbrain.BasePageObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class demoqaTest extends BasePageObject {
    WebDriver driver;
    demoqaPageObject demoqaPageObject;

    @BeforeTest
    public void initialize() {
        driver = getChromeDriver();
        demoqaPageObject = new demoqaPageObject(driver);
        demoqaPageObject.langOnDemoqa();
    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }

    @DataProvider(name = "sectionName")
    public Object[][] sectionName() {
        return new Object[][]{
                {"Elements"},
                {"Widgets"},
                {"Forms"},
                {"Interactions"}
        };
    }

    @Test
    public void navigateToButtonsSection() throws IOException {
        try {
            demoqaPageObject.clickOnElements();
            demoqaPageObject.navigateToButtonsSection();
            Assert.assertTrue(driver.getCurrentUrl().contains("buttons"));
        } catch (Exception e) {
            takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test(dependsOnMethods = "navigateToButtonsSection")
    public void checkDoubleClickButton() throws IOException {
        try {
            demoqaPageObject.doubleClickButton();
            Assert.assertEquals(driver.findElement(By.id("doubleClickMessage")).getText(), "You have done a double click");


        } catch (Exception e) {
            takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test(dependsOnMethods = "navigateToButtonsSection")
    public void checkRightClickButton() throws IOException {
        try {
            demoqaPageObject.rightClickButton();
            Assert.assertTrue(driver.findElement(By.id("rightClickMessage")).isDisplayed());
        } catch (Exception e) {
            takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }

    }

    @Test(dependsOnMethods = "navigateToButtonsSection")
    public void checkDynamicClickButton() throws IOException {
        try {
            demoqaPageObject.dynamicClickButton();
            Assert.assertTrue(driver.findElement(By.id("dynamicClickMessage")).getText().contains("dynamic click"));
        } catch (Exception e) {
            takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test(dataProvider = "sectionName")
    public void navigateToSections(String sectionName) throws IOException {
        try {
            demoqaPageObject.navigateToSections(sectionName);
            Assert.assertTrue(driver.getCurrentUrl().contains(sectionName));

        } catch (Exception e) {
            takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }

    }

    @Test
    public void navigateToNewWindow() throws IOException {
        try {
            demoqaPageObject.openNewWindow();
            Assert.assertTrue(driver.findElement(By.cssSelector("body")).isDisplayed());

        } catch (Exception e) {
            takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }


    }

    @Test
    public void navigateToAlerts() throws IOException {
        try {
            demoqaPageObject.navigateToAlertsFrameWindows();
            demoqaPageObject.navigateToAlertsSection();
        } catch (Exception e) {
            takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test(dependsOnMethods = "navigateToAlerts")
    public void alertCheck() throws IOException {
        try{demoqaPageObject.clickAlertButton("Alert");
           Assert.assertEquals(demoqaPageObject.getAlertText(), "You clicked a button");
            demoqaPageObject.acceptAlert();

        }
        catch (Exception e) {
            takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test(dependsOnMethods = "navigateToAlerts")
    public void timerAlertCheck() throws IOException {
        try{
            demoqaPageObject.clickAlertButton("Timer Alert");
            demoqaPageObject.acceptAlert();
        }
        catch (Exception e) {
            takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }
    @Test(dependsOnMethods = "navigateToAlerts")
    public void confirmBoxAlertCheck() throws IOException {
        try{demoqaPageObject.clickAlertButton("Confirm Box");
           Assert.assertTrue(demoqaPageObject.getAlertText().contains("Do you confirm action?"));
            demoqaPageObject.dismissAlert();

        }
        catch (Exception e) {
            takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }
    @Test(dependsOnMethods = "navigateToAlerts")
    public void promptBoxAlertCheck() throws IOException {
        try{demoqaPageObject.clickAlertButton("Prompt Box");
            demoqaPageObject.enterTextInPromptAlert("Test");
            Assert.assertTrue(demoqaPageObject.getAlertText().contains("Please enter your name"));
            //Assert.assertEquals(demoqaPageObject.getAlertText(), "Please enter your name");
            demoqaPageObject.acceptAlert();
        }
        catch (Exception e) {
            takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }



}