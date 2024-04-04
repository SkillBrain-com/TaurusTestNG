package KateaManoila;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.skillbrain.BasePageObject;

import java.time.Duration;

public class EmagPageObject extends BasePageObject {
    private static final String EMAG_HOME_PAGE = "https://www.emag.ro/";

    //    @FindBy(css = ".btn.btn-primary.js-accept.gtm_h76e8zjgoo.btn-block")
//    private WebElement acceptAll;
    @FindBy(xpath = "//button[@class='close'")
    private WebElement closeOfferOfTheDay;
    @FindBy(xpath = "//a[text()='Intra in cont']")
    private WebElement enterYourAccount;


    public void closeOfferOfTheDay() {
        closeOfferOfTheDay.click();
    }

    public void goToEmagHomePage() {
        driver.get(EMAG_HOME_PAGE);
    }

    public void enterYouAccount() {
        enterYourAccount.click();
    }

    public void clickAcceptAll() {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementClickInterceptedException.class);

        WebElement acceptButton = fluentWait.until(webdriver -> webdriver.findElement(By.cssSelector(".btn.btn-primary.js-accept.gtm_h76e8zjgoo.btn-block")));
        int retry = 3;
        while (retry > 0) {

        }
        try {
            acceptButton.click();
        } catch (Exception e) {
            retry--;
        }


    }

    public EmagPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

}
