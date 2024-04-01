package TimeeaPop.Selenium2;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class HerokuAppBasicHTMLFormExampleTest extends BasePageObject {
    WebDriver driver;
    HerokuAppBasicHTMLFormExamplePageObject herokuAppBasicHTMLFormExamplePageObject;

    @BeforeTest
    public void initialize() {
        driver = getChromeDriver();
        herokuAppBasicHTMLFormExamplePageObject = new HerokuAppBasicHTMLFormExamplePageObject(driver);
    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }

    @Test
    public void completeForm() throws IOException {
        try {
            herokuAppBasicHTMLFormExamplePageObject.landOnBasicHTMLFormExamplePage();
            herokuAppBasicHTMLFormExamplePageObject.clickAndCompleteUsernameField();
            herokuAppBasicHTMLFormExamplePageObject.clickAndCompletePasswordField();
            herokuAppBasicHTMLFormExamplePageObject.clickAndCompleteTextAreaCommentField();
            herokuAppBasicHTMLFormExamplePageObject.selectFirstCheckBox();
            herokuAppBasicHTMLFormExamplePageObject.selectSecondCheckBox();
            herokuAppBasicHTMLFormExamplePageObject.selectThirdCheckBox();//this was already selected on the page, so by clicking on it we deselect it
            herokuAppBasicHTMLFormExamplePageObject.selectFirstRadioButton();
            herokuAppBasicHTMLFormExamplePageObject.takeScreenshot(driver);
            herokuAppBasicHTMLFormExamplePageObject.clickOnSubmitButton();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            Assert.assertEquals(driver.getCurrentUrl(),"https://testpages.eviltester.com/styled/the_form_processor.php");
            herokuAppBasicHTMLFormExamplePageObject.checkSubmittedUsername();
            herokuAppBasicHTMLFormExamplePageObject.checkSubmittedPassword();
            herokuAppBasicHTMLFormExamplePageObject.checkSubmittedComment();
            herokuAppBasicHTMLFormExamplePageObject.checkSubmittedFirstCheckBox();
            herokuAppBasicHTMLFormExamplePageObject.checkSubmittedSecondCheckBox();
            herokuAppBasicHTMLFormExamplePageObject.checkSubmittedRadioButton();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            herokuAppBasicHTMLFormExamplePageObject.takeScreenshot(driver);
        } catch(Exception e) {
            herokuAppBasicHTMLFormExamplePageObject.takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }
}
