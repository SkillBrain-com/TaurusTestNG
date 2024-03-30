package MariusMurgulet;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.skillbrain.BasePageObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

public class HeroTest extends BasePageObject {
//    WebDriver driver;
        RemoteWebDriver driver;
    HerokuappPage herokuappPage;

    @BeforeTest
    public void initialize() throws MalformedURLException {
//        driver = getChromeDriver();
        driver = getRemoteDriver();
        herokuappPage = new HerokuappPage(driver);
    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }


//    public static void main(String[] args) throws IOException {
//        BasePageObject basePageObject = new BasePageObject();
//        WebDriver chromeDriver = basePageObject.getChromeDriver();
//        HerokuappPage hero = new HerokuappPage(chromeDriver);
//        try {
//           hero.gotoHeroHomePage();
////            hero.clickBasicWebPageLink();
////            chromeDriver.navigate().back();
////            hero.clickElementAttributesLink();
////            chromeDriver.navigate().back();
////            hero.clickFindbytest();
////            chromeDriver.navigate().back();
////            hero.clickWebdriverExamplePage();
//            //           hero.firstAlertTest();
//            //           hero.secondAlertTest();
//            //          hero.thirdAlertTest();
//            hero.fakeAlertTest();
//        } catch (Exception e) {
//            hero.takeScreenshot(chromeDriver);
//            e.printStackTrace();
//        } finally {
//            chromeDriver.quit();
//        }
//    }

    @DataProvider(name = "pageList")
    public static Object[][] getPageLinks() {
        return new Object[][]{
                {"basic-web-page-test"},
                {"attributes-test"},
                {"find-by-playground-test"},
                {"webdriver-example-page"}
        };
    }

    @DataProvider(name = "alertList")
    public static Object[][] getAlertLinks() {
        return new Object[][]{
                {"alert-test"},
                {"fake-alert-test"}
        };
    }

    @Test(dataProvider = "pageList")
    public void pageCheckTest(String page) throws IOException {
        try {
            herokuappPage.gotoHeroHomePage(page);
//            String pageTitle = herokuappPage.gotoHeroHomePage(page);
//            System.out.println("Page title: " + pageTitle);
//            String bodyText = driver.findElement(By.tagName("h1")).getText();
//            System.out.println("Header text of " + page + ":\n" + bodyText);

        } catch (Exception e) {
            takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test(dataProvider = "alertList")
    public void alertTests(String page) throws IOException {
        try {
            herokuappPage.gotoHeroAlertPage(page);
            if (page.equals("alert-test")) {
                herokuappPage.firstAlertTest();
                herokuappPage.secondAlertTest();
                herokuappPage.thirdAlertTest();
            } else if (page.equals("fake-alert-test")) {
                herokuappPage.fakeAlertTest();
                Assert.assertEquals(driver.getCurrentUrl(), "https://testpages.eviltester.com/styled/alerts/fake-alert-test.html");
            }
        } catch (Exception e) {
            takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }

    }
}
