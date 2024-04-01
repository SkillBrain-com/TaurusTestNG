package TimeeaPop.Selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoQAPageObject extends BasePageObject{
    private static final String DEMOQA_HOME_PAGE = "https://demoqa.com";

    @FindBy(css=".fc-button.fc-cta-consent.fc-primary-button")
    private WebElement consentButton;

    //constructor
    public DemoQAPageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this); // Asa initializam elementele din DemoQAPajeObject
    }
    public void landOnDemoqaPage(){
        driver.get(DEMOQA_HOME_PAGE);
    }

    public void clickOnConsentButton() {
        consentButton.click();
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void fillInName(String john) {
        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("John");
    }
}
