package AdinaPecie.SeleniumTaurus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoqaSamplePageObject extends BasePageObject {

    @FindBy (id = "sampleHeading")
    private WebElement sampleHeading;

    public boolean headingContains(String expected){
        return sampleHeading.getText().contains(expected);
    }
    public DemoqaSamplePageObject (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
//        PageFactory.initElements(driver, DemoqaSamplePageObject.class);
    }

}