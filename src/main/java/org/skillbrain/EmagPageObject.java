package org.skillbrain;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class EmagPageObject extends BasePageObject {

    private static final String EMAG_HOME_PAGE = "https://emag.ro";

    @FindBy(css = ".btn.btn-primary.js-accept.gtm_h76e8zjgoo.btn-block")
    private WebElement acceptAll;
    @FindBy(xpath = "//button[@class='close']")
    private WebElement closeOfferOfTheDay;
    @FindBy(xpath = "//a[text()='Intra in cont']")
    private WebElement enterYourAccount;


    public void closeOfferOfTheDay() {
        closeOfferOfTheDay.click();
    }

    public void goToEmagHomePage() {
        driver.get(EMAG_HOME_PAGE);
    }

    public void enterYourAccount() {
        driver.findElement(By.cssSelector(".gdpr-cookie-banner.js-gdpr-cookie-banner.pad-sep-xs.pad-hrz-none.login-view.login-view-ro.show")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Intra in cont']"))).click();
        int retry = 3;
        while (retry >0) {
            try {
                enterYourAccount.click();
            } catch (Exception e) {
                retry--;
            }
        }
    }

    public void clickAcceptAll() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-primary.js-accept.gtm_h76e8zjgoo.btn-block")));
        int retry = 3;
        while (retry >0) {
            try {
                acceptButton.click();
            } catch (Exception e) {
                retry--;
            }
        }
    }

    public EmagPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
