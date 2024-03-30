package CarmenOltean;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.skillbrain.BasePageObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

public class KatalonTest extends BasePageObject {
    //WebDriver driver;
    RemoteWebDriver driver;
    KatalonPageObject katalonPageObject;

    @BeforeTest
    public void initialize() throws MalformedURLException {
        driver = getRemoteDriver();
        katalonPageObject = new KatalonPageObject(driver);
        katalonPageObject.langOnKatalon();
    }

    @AfterTest
    public void endTest(){
        driver.quit();
    }


    @DataProvider(name = "loginData")
    public Object[][] loginData(){
        return new Object[][]{
                {"John Doe", "ThisIsNotAPassword"},
                {"Tom", "newPassword"}
        };
    }


    @Test
    public void navigateToLoginSection() throws IOException {
        try {
           katalonPageObject.clickOnMenuButton();
           katalonPageObject.clickOnLogInBtn();
           Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/profile.php#login");

        }
        catch (Exception e) {
            takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();

        }
    }
    @Test(dataProvider = "loginData" , dependsOnMethods = "navigateToLoginSection")
    public void enterCredentials(String username, String password) throws IOException {
        try {
            katalonPageObject.enterLoginData(username,password);
           // Assert.assertTrue(driver.findElement(By.xpath("//p[@class='lead text-danger']")).isDisplayed(), "Error message is displayed");
        }
        catch(Exception e){
            takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test()
    public void makeAppointmentBtnCheck() throws IOException {
        try{
            katalonPageObject.makeAppointment();
            Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/profile.php#login");
        }
        catch(Exception e){
            takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
    }

   @Test
    public void homeBtnCheck() throws IOException {
        try{
            katalonPageObject.makeAppointment();
            katalonPageObject.clickOnMenuButton();
            katalonPageObject.clickOnHomeBtn();
            Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/");
        }
        catch(Exception e){
            takeScreenshot(driver);
            e.printStackTrace();
            Assert.fail();
        }
   }



}
