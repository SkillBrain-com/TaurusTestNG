package TimeeaPop.Selenium3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DisabledDynamicButtonPageObject extends BasePageObjectS3 {
    private static final String DISABLED_DYNAMIC_BUTTON_PAGE = "https://testpages.herokuapp.com/styled/dynamic-buttons-simple.html";

    public void landOnDisableDynamicButtonPage() {
        driver.get(DISABLED_DYNAMIC_BUTTON_PAGE);
    }

    public DisabledDynamicButtonPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "button00")
    private WebElement startButton;

    public void clickOnStartButton() {
        startButton.click();
    }

    @FindBy(id = "button01")
    private WebElement firstButton;

    public void clickOnButtonNumberOne() {
        firstButton.click();
        waitMessage.click();
    }

    @FindBy(id = "button02")
    private WebElement secondButton;
    public void clickOnButtonNumberTwo() {
        secondButton.click();
        waitMessage.isDisplayed();
    }

    @FindBy(id = "button03")
    private WebElement thirdButton;
    public void clickOnButtonNumberThree() {
        thirdButton.click();
        waitMessage.isDisplayed();
    }
    @FindBy(id = "waitmessage")
    private WebElement waitMessage;

    @FindBy(id = "buttonmessage")
    private WebElement buttonMessageText;
    public void successMessageIsDisplayed() {
        buttonMessageText.isDisplayed();
        System.out.println(buttonMessageText.getText());
    }
}
