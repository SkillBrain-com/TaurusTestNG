package SeleniumTaurus;

import AdinaPecie.CursSelenium.BasePageObject;
import AdinaPecie.CursSelenium.EmagPageObject;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TestEmag {
    public static void main(String[] args) throws IOException {


        BasePageObject basePageObject = new BasePageObject();
        WebDriver chromeDriver = basePageObject.getChromeDriver();
        EmagPageObject emag = new EmagPageObject(chromeDriver);


        try {
            emag.goToEmagHomePage();
            emag.clickAcceptAll();
            emag.clickOfferOfTheDay();
            emag.enterYourAccout();
        } catch (Exception e) {
            emag.takeScreenshot(chromeDriver);
            e.printStackTrace();
        } finally {
            chromeDriver.quit();
        }
    }
}
