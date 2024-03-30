package CarmenOltean;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.skillbrain.BasePageObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class demoqaPageObject extends BasePageObject {
    private static final String DEMOQA_HOME_PAGE = "https://demoqa.com/";
    public demoqaPageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[@class='rct-collapse rct-collapse-btn'][1]")
    private WebElement homeBtn;

    @FindBy(id = "item-1")
    private WebElement CheckBoxBtn;
    @FindBy(xpath = "(//h5[text()='Elements']//ancestor::div[@class='card mt-4 top-card'])")
    private WebElement elementsCard;
    @FindBy(id = "result")
    private WebElement resultMessage;
    @FindBy(xpath = "//*[name()='svg'][@class='rct-icon rct-icon-parent-open']")
    private WebElement homeSelection;
    @FindBy(xpath = "//span[text()='Buttons']")
    private WebElement buttonsBtn;
    @FindBy(id = "doubleClickBtn")
    private WebElement doubleClickBtn;
    @FindBy(id = "rightClickBtn")
    private WebElement rightClickBtn;
    @FindBy(xpath = "//button[text()='Click Me']")
    private WebElement dynamicClickBtn;
    @FindBy(id = "messageWindowButton")
    private WebElement newWindowBtn;
    @FindBy(id = "alertButton")
    WebElement alertButton;

    @FindBy(id = "timerAlertButton")
    WebElement timerAlertButton;

    @FindBy(id = "confirmButton")
    WebElement confirmButton;

    @FindBy(id = "promtButton")
    WebElement promptButton;
    @FindBy(xpath = "(//h5[text()='Alerts, Frame & Windows']//ancestor::div[@class='card mt-4 top-card'])")
    private WebElement alertsCard;
    @FindBy(xpath = "//span[@class='text'][text()='Alerts']")
    WebElement alertsBtn;




    public void langOnDemoqa (){
        driver.get(DEMOQA_HOME_PAGE);
    }

    public void clickOnHomeBtn(){
        homeBtn.click();
    }
    public void clickOnCheckBoxBtn(){
        CheckBoxBtn.click();
    }
    public void clickOnElements(){
        elementsCard.click();
    }
    public void showResultMessage(){
        System.out.println(resultMessage.getText());
    }
    public void selectHome(){
        homeSelection.click();
    }
    public void navigateToButtonsSection(){
        buttonsBtn.click();
    }
    public void doubleClickButton(){
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickBtn).build().perform();
    }
    public void rightClickButton(){
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickBtn).build().perform();
    }
    public void dynamicClickButton(){
        Actions actions = new Actions(driver);
        actions.click(dynamicClickBtn).build().perform();
    }
    public void navigateToSections(String card){
        String url = String.format("https://demoqa.com/%s",card);
        driver.get(url);
    }
    public void openNewWindow(){
        driver.get("https://demoqa.com/browser-windows");
        newWindowBtn.click();
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowId = new ArrayList<>(windowHandles);
        driver.switchTo().window(windowId.get(1));
        driver.switchTo().window(windowId.get(0));

    }
    public void navigateToAlertsFrameWindows(){
        alertsCard.click();
    }
    public void navigateToAlertsSection(){
        alertsBtn.click();
    }
    public void clickAlertButton(String buttonName) {
        switch (buttonName.toLowerCase()) {
            case "alert":
                alertButton.click();
                break;
            case "timer alert":
                timerAlertButton.click();
                break;
            case "confirm box":
                confirmButton.click();
                break;
            case "prompt box":
                promptButton.click();
                break;
            default:
                System.out.println("Invalid button name");
        }

    }


    public String getAlertText() {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        return alertText;


    }

    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void dismissAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void enterTextInPromptAlert(String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
    }
}





