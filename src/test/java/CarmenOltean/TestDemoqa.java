package CarmenOltean;

import org.openqa.selenium.WebDriver;
import org.skillbrain.BasePageObject;

import java.io.IOException;

public class TestDemoqa {
    public static void main(String[] args) throws IOException {


        org.skillbrain.BasePageObject bpo = new BasePageObject();
        WebDriver chromeDriver = bpo.getChromeDriver();
        demoqaPageObject dqa = new demoqaPageObject(chromeDriver);

        try {
            dqa.langOnDemoqa();
            dqa.clickOnElements();
            dqa.clickOnCheckBoxBtn();
            dqa.clickOnHomeBtn();
            dqa.selectHome();
            dqa.showResultMessage();


        } catch (Exception e) {
            bpo.takeScreenshot(chromeDriver);
            e.printStackTrace();

        }
        finally {
            chromeDriver.quit();
        }
    }
}