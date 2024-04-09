package TimeeaPop.Selenium3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SimpleDynamicButtonPageObject extends BasePageObjectS3 {
    private static final String SIMPLE_DYNAMIC_BUTTON_PAGE = "https://testpages.herokuapp.com/styled/dynamic-buttons-simple.html";
    public void landOnSimpleDynamicButtonPage(){
        driver.get(SIMPLE_DYNAMIC_BUTTON_PAGE);
    }
    public SimpleDynamicButtonPageObject (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "button00")
    private WebElement startButton;
    public void clickOnStartButton() throws InterruptedException {
        startButton.click();
        //startButton.wait(2000);
    }

    @FindBy(id = "waitmessage")
    private WebElement waitMessage;

    @FindBy(id = "button01")
    private WebElement firstButton;
    public void clickOnButtonNumberOne() throws InterruptedException {
        firstButton.click();
        waitMessage.isDisplayed();
        //firstButton.wait(2000);
    }

    @FindBy(id = "button02")
    private WebElement secondButton;
    public void clickOnButtonNumberTwo() throws InterruptedException {
        secondButton.click();
        waitMessage.isDisplayed();
       // secondButton.wait(2000);
    }

    @FindBy(id = "button03")
    private WebElement thirdButton;
    public void clickOnButtonNumberThree() throws InterruptedException {
        thirdButton.click();
//        waitMessage.isDisplayed();
        //thirdButton.wait(2000);
    }

    @FindBy(id = "buttonmessage")
    private WebElement buttonMessageText;
    public void successMessageIsDisplayed() {
        buttonMessageText.isDisplayed();
        System.out.println(buttonMessageText.getText());
    }
}
