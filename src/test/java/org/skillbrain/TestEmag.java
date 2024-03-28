package org.skillbrain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

import static org.skillbrain.DemoqaPage.driver;

public class TestEmag {

    public static void main(String[] args) throws IOException {
        BasePageObject basePageObject = new BasePageObject();
        WebDriver chromeDriver = basePageObject.getChromeDriver();
        EmagPageObject emag = new EmagPageObject(chromeDriver);

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
