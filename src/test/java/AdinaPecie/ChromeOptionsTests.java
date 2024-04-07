package AdinaPecie;

import PageObjects.EmagPage;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static PageObjects.EmagPage.*;
import static org.testng.Assert.assertTrue;

public class ChromeOptionsTests {
    ChromeDriver driver;
//    s a initializat in EmagPage
//    EmagPage emagPage = PageFactory.initElements(driver, EmagPage.class);

    @AfterMethod
    public void afterMethod(){
        if (driver !=null) {
            driver.quit();
        }
    }

    @Test
    public void mobileTest(){
       driver = WebdriverManager.getChromeDriverWithOptions();
        driver.get("https://demoqa.com/");
        driver.quit();
    }
@Test
    public void implicitWaitTest() {
        driver = WebdriverManager.getChromeDriverWithOptions();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

EmagPage emagPage = PageFactory.initElements(driver,EmagPage.class);
// sau  EmagPage emagPage = new EmagPage(driver); se initializeaza elementele din test
        driver.get("https://www.emag.ro/");

        emagPage.getAcceptButton().click();
    emagPage.getLoginButton().click();

    driver.quit();
    }

    @Test
    public void explicitWaitTest(){
        driver = WebdriverManager.getChromeDriverWithOptions();

        EmagPage emagPage = new EmagPage(driver);
//        sau EmagPage emagPage = PageFactory.initElements(driver,EmagPage.class);
//        se initializeaza elementele din test prin constructorul clasei de testObjects
    driver.get("https://www.emag.ro/");

//        WebDriverWait
//        FluentWait cu ajutorul lor cream obiecte de wait

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ACCEPT_BUTTON_CSS)));
        emagPage.getAcceptButton().click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CLOSE_BUTTON_CSS)));
      emagPage.getButtonClose().click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(LOGIN_BUTTON_CSS)));
       emagPage.getLoginButton().click();

        assertTrue(driver.getCurrentUrl().contains("user/login"), "Login page did not open");

    }
}
