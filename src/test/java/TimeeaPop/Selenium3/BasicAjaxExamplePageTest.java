package TimeeaPop.Selenium3;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

public class BasicAjaxExamplePageTest extends BasePageObjectS3{
    WebDriver driver;
    BasicAjaxExamplePageObject basicAjaxExamplePageObject;

    @BeforeTest
    public void initialize() throws MalformedURLException {
        driver = getChromeDriver();
        //driver = getRemoteDriver();
        basicAjaxExamplePageObject = new BasicAjaxExamplePageObject(driver);
    }
    @AfterTest
    public void endTest() {
        driver.quit();
    }

    @Test
    public void selectCategoryAndLanguageAndSubmit() throws IOException {
        try {
            basicAjaxExamplePageObject.landOnBasicAjaxExamplePage();
            basicAjaxExamplePageObject.clickOnCategoryListAndChoose();
            basicAjaxExamplePageObject.clickOnLanguageListAndChoose();
            basicAjaxExamplePageObject.clickOnSubmitButton();
            basicAjaxExamplePageObject.checkCurrentURL();
            basicAjaxExamplePageObject.checkSubmittedCategory();
            basicAjaxExamplePageObject.checkSubmittedLanguage();
            basicAjaxExamplePageObject.checkSubmittedSubmitButtonValue();
        } catch (Exception e) {
            basicAjaxExamplePageObject.takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }
}
