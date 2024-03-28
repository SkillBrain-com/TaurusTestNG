package sanduCristian;

import org.openqa.selenium.WebDriver;
import org.skillbrain.BasePageObject;
import org.skillbrain.EmagPageObject;

import java.io.IOException;

public class TestEmag {

    public static void main(String[] args) throws IOException {
        org.skillbrain.BasePageObject basePageObject = new BasePageObject();
        WebDriver chromeDriver = basePageObject.getChromeDriver();
        org.skillbrain.EmagPageObject emag = new EmagPageObject(chromeDriver);

        try {
            emag.goToEmagHomePage();
            emag.clickAcceptAll();
            emag.closeOfferOfTheDay();
        } catch (Exception e) {
            e.printStackTrace();
            emag.takeScreenshot(chromeDriver);
        } finally {
            chromeDriver.quit();
        }



    }
}
