package MadalinVoicu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoqaPageObject extends BasePageObject{
    private static final String DEMOQA_HOME_PAGE = "https://demoqa.com";

    @FindBy(css=".fc-button.fc-cta-consent.fc-primary-button")
    private WebElement consentButton;
    public void clickOnConsentButton() {
        consentButton.click();
    }

    public DemoqaPageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this); // Asa initializam elementele din DemoQAPajeObject
    }
    public void landOnDemoqaPage(){
        driver.get(DEMOQA_HOME_PAGE);
    }

}