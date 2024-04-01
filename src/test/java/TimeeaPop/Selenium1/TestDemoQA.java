package TimeeaPop.Selenium1;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class TestDemoQA extends BasePageObject{
    WebDriver driver;
    DemoQAPageObject demoQAPageObject;
    @BeforeTest
    public void initialize() {
        driver = getChromeDriver();
        demoQAPageObject = new DemoQAPageObject(driver);
    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }


    public static void main(String[] args) throws IOException {
        BasePageObject bpo = new BasePageObject();
        WebDriver chromeDriver = bpo.getChromeDriver();
        DemoQAPageObject demoQAPageObject = new DemoQAPageObject(chromeDriver);

        try {
            demoQAPageObject.landOnDemoqaPage();
            demoQAPageObject.clickOnConsentButton();
            demoQAPageObject.fillInName("John");
        } catch (Exception e) {
            bpo.takeScreenshot(chromeDriver);
            e.printStackTrace();
        } finally {
            chromeDriver.quit();
        }
    }


}
