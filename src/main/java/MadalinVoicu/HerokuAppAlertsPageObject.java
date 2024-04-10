package MadalinVoicu;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HerokuAppAlertsPageObject extends BasePageObject{
    private static final String ALERT_BOX_EXAMPLES_PAGE = "https://testpages.eviltester.com/styled/alerts/alert-test.html";

    @FindBy(id = "alertexamples")
    private WebElement showAlertBox;

    @FindBy(id = "alertexplanation")
    private WebElement successMessageFromFirstAlert;

    @FindBy(id = "confirmexample")
    private WebElement showConfirmBox;

    @FindBy(id = "confirmexplanation")
    private WebElement confirmMessage;

    @FindBy(id = "confirmreturn")
    private WebElement confirmReturn;

    @FindBy(id = "promptexample")
    private WebElement showPromptBox;

    @FindBy(id = "promptreturn")
    private WebElement promptReturn;

    @FindBy(id = "promptexplanation")
    private WebElement promptExplanation;



    public void changePromptAlertTextAndConfirm(){
        Alert alert = driver.switchTo().alert();
        Actions actions = new Actions(driver);
//        actions.sendKeys(Keys.chord(Keys.CONTROL, "a")).sendKeys(Keys.DELETE).build().perform();
//        alert.sendKeys("test");
        alert.accept();
        System.out.println("Message displayed after accepting prompt alert: " + promptExplanation.getText());
    }
    public void dismissPromptAlert(){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        Assert.assertTrue(promptExplanation.isDisplayed());
        Assert.assertFalse(promptReturn.isDisplayed());
        System.out.println("Message displayed after dismissing prompt alert: " + promptExplanation.getText());
    }

    public void clickOnShowPromptBox() {
        showPromptBox.click();
    }

    public void clickOnShowConfirmBoxButton() {
        showConfirmBox.click();
    }
    public void acceptConfirmAlertAndCloseIt() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Assert.assertTrue(confirmMessage.isDisplayed());
        Assert.assertTrue(confirmReturn.isDisplayed());
        System.out.println("Message from confirm Alert after accepting it: " + confirmMessage.getText());
        System.out.println("Return value from confirm Alert after accepting it: " + confirmReturn.getText());
    }
    public void cancelConfirmAlertAndCloseIt() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        Assert.assertTrue(confirmMessage.isDisplayed());
        Assert.assertTrue(confirmReturn.isDisplayed());
        System.out.println("Message from confirm Alert after canceling it: " + confirmMessage.getText());
        System.out.println("Return value from confirm Alert after canceling it: " + confirmReturn.getText());
    }

    public void clickOnShowAlertBoxButton() {
        showAlertBox.click();
    }
    public void checkFirstAlertAndCloseIt() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Assert.assertTrue(successMessageFromFirstAlert.isDisplayed());
        System.out.println("Message from first Alert: " + successMessageFromFirstAlert.getText());
    }

    public void landOnAlexBoxExamplePage () {
        driver.get(ALERT_BOX_EXAMPLES_PAGE);
    }

    public HerokuAppAlertsPageObject (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

