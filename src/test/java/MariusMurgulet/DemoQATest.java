package MariusMurgulet;

import org.openqa.selenium.WebDriver;
import org.skillbrain.BasePageObject;
import org.skillbrain.DemoqaPageObject;
import org.skillbrain.DemoqaSamplePageObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

public class DemoQATest extends BasePageObject {

    WebDriver driver;
    //RemoteWebDriver driver;
    org.skillbrain.DemoqaPageObject demoqaPageObject;

    @BeforeTest
    public void initialize() throws MalformedURLException {
        driver = getChromeDriver();
        //driver = getRemoteDriver();
        demoqaPageObject = new DemoqaPageObject(driver);
    }

    @AfterTest
    public void endTest(){
        driver.quit();
    }

    @Test(dependsOnMethods = "switchToNewWindowTab()", groups = "Group1")
    public void fillInPracticeForm() throws IOException {
        try{
            demoqaPageObject.landOnDemoqaPage();
            Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/");
            //demoqaPageObject.clickOnConsentButton();
            demoqaPageObject.clickOnCard("Forms");
            demoqaPageObject.clickPracticeFormList();
            //new SoftAssert(river.getCurrentUrl(), "https://demoqa.com/automation-practice-form");
            Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/automation-practice-form");
            demoqaPageObject.fillInFirstNameField("Cristian");
        } catch (Exception e){
            takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test(groups = "Group1")
    public void switchToNewWindowTab() throws IOException {
        try{
            demoqaPageObject. goToBrowserWindowPage();
            demoqaPageObject.clickNewTabButton();
            demoqaPageObject.switchToWindowTab("SECOND");
            DemoqaSamplePageObject demoqaSamplePageObject = new DemoqaSamplePageObject(driver);
            Assert.assertTrue(demoqaSamplePageObject.headingContains("This is a sample page"));
        } catch (Exception e){
            takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }

    @DataProvider(name = "pageList")
    public Object[][] myPageProvider(){
        return new Object[][]{
                {"elements"},
                {"forms"},
                {"alertWindows"},
                {"books"},
                {"widgets"}
        };
    }

    @Test(dataProvider = "pageList",groups = "Group2")
    public void pageCheckTest(String page) throws IOException {
        try{
            demoqaPageObject.navigateToPage(page);
//            Assert.assertTrue(driver.findElement(
//                    By.xpath("//span[text()='Text Box'] //parent::li")).isDisplayed());
        }catch (Exception e){
                takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }

    }


 }

