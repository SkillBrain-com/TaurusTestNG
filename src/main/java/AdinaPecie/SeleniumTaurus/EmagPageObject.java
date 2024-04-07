package AdinaPecie.SeleniumTaurus;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmagPageObject extends BasePageObject {

    private static final String EMAG_HOME_PAGE = "https://emag.ro";

    @FindBy (css =".btn.btn-primary.js-accept.gtm_h76e8zjgoo.btn-block")
    private WebElement acceptAll;

    @FindBy(css = "//button[@class='close']")
    private WebElement closeOfferOfTheDay;

    @FindBy(xpath = "//a[text()='Intra in cont']")
    private WebElement enterYourAccout;

    public void goToEmagHomePage(){
        driver.get(EMAG_HOME_PAGE);
    }

    public void enterYourAccout(){
//        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(10))
//                .pollingEvery(Duration.ofMillis(200))
//                .ignoring(NoSuchElementException.class)
//                .ignoring(ElementClickInterceptedException.class)
//        .ignoring(ElementNotInteractableException.class);
//        WebElement enterYourAccount = fluentWait.until(webdriver -> webdriver.findElement(By.xpath("//a[text()='Intra in cont']")));
//        enterYourAccount.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Intra in cont']"))).click();
    }

    public void clickOfferOfTheDay(){
        closeOfferOfTheDay.click();
    }

    public void clickAcceptAll(){

        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                        .pollingEvery(Duration.ofMillis(200))
                                .ignoring(NoSuchElementException.class)
                                        .ignoring(ElementClickInterceptedException.class);

      WebElement acceptButton =  fluentWait.until(webdriver->webdriver.findElement(By.cssSelector(".btn.btn-primary.js-accept.gtm_h76e8zjgoo.btn-block")));
        FluentWait<WebElement> webElementFluentWait = new FluentWait<>(acceptButton);
                int retry = 3;
        while(retry >0) {

            try {
                acceptButton.click();
            } catch (Exception e) {
                retry--;

            }
        }
//        acceptAll.click();
    }




    public EmagPageObject(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }



}
