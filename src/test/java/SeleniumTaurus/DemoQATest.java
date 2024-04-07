package SeleniumTaurus;

import AdinaPecie.CursSelenium.BasePageObject;
import AdinaPecie.CursSelenium.DemoqaPageObject;
import AdinaPecie.CursSelenium.DemoqaSamplePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

public class DemoQATest extends BasePageObject {

//    WebDriver driver;
    RemoteWebDriver driver;

    DemoqaPageObject demoqaPageObject;


    @BeforeTest
    public void initialize() throws MalformedURLException {

//        driver = getChromeDriver();
        driver = getRemoteDriver();
        demoqaPageObject = new DemoqaPageObject(driver);
    }

    @AfterTest
    public void endTest() {
        driver.quit();
//      driver.close();
    }


    @Test()
    public void fillInPracticeForm() throws IOException {

        try {
            demoqaPageObject.langOnDemoqaPage();
            Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/");
//            demoqaPageObject.clickOnConsentButton();
            demoqaPageObject.clickOnCard("Forms");
            Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/forms");
            demoqaPageObject.clickPracticeFormList();
            Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/automation-practice-form");
            demoqaPageObject.fillInFirstNameField("Joe");
        } catch (Exception e) {
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
                {"alertsWindows"},
                {"books"},
                {"widgets"}
        };
    }

@Test (dataProvider = "pageList", groups = "Group2")
    public void pageCheckTest (String page) throws IOException {
        try{
            demoqaPageObject.navigateToPage(page);

        }catch(Exception e){
            takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test(groups = "Group1")
    public void switchToNewWindowTab() throws IOException {
        try{
demoqaPageObject.goToBrowserWindowPage();
demoqaPageObject.clickNewTabButton();
demoqaPageObject.switchToWindowTab("SECOND");
DemoqaSamplePageObject demoqaSamplePageObject = new DemoqaSamplePageObject(driver);

Assert.assertTrue(demoqaSamplePageObject.headingContains("This is a sample page"));
        }catch(Exception e){
            takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }

    }

}