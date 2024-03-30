package MariusMurgulet;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.skillbrain.BasePageObject;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DemoqaPageObject extends BasePageObject {
    @FindBy(css = ".fc-button.fc-cta-consent.fc-primary-button")
    private WebElement consentButton;

    @FindBy(id = "userName")
    private WebElement nameField;
    @FindBy(xpath = "//span[text()='Practice Form'] //parent::li")
    private WebElement practiceFormList;
    @FindBy(id = "firstName")
    private WebElement firstNameField;
    @FindBy(id = "tabButton")
    private WebElement newTabButton;

    private static final String DEMOQA_HOME_PAGE = "https://demoqa.com";
    private static final String DEMOQA_BROWSER_WINDOWS_PAGE = "https://demoqa.com/browser-windows";

    public void navigateToPage(String page){
        driver.get(String.format("https://demoqa.com/%s",page));
    }
    public void switchToWindowTab(String tab) {
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowId = new ArrayList<>(windowHandles);

        switch (tab.toLowerCase()) {
            case "first":
                driver.switchTo().window(windowId.get(0));
                break;
            case "second":
                driver.switchTo().window(windowId.get(1));
                break;
            default:
                Assert.fail("User didn't select between first and second window tab.");

        }
    }

    public void clickNewTabButton() {
        newTabButton.click();
    }

    public void goToBrowserWindowPage() {
        driver.get(DEMOQA_BROWSER_WINDOWS_PAGE);
    }

    public DemoqaPageObject(WebDriver driver) {
        this.driver = driver;
//        PageFactory.initElements(driver, DemoqaPage.class);
        PageFactory.initElements(driver, this); // echivalent
    }


    public void fillInFirstNameField(String input) {
        if (!firstNameField.getAttribute("value").isEmpty()) {
            firstNameField.clear();
        }
        firstNameField.sendKeys(input);
    }

    public void clickPracticeFormList() {
        practiceFormList.click();
    }

    public void fillInName(String input) {
        nameField.sendKeys(input);
    }

    public void landOnDemoqaPage() {
        driver.get(DEMOQA_HOME_PAGE);
    }

    public void clickOnConsentButton() {
        consentButton.click();
    }

    public void clickOnCard(String card) {
        driver.findElement(By.xpath("//h5[text()='" + card + "'] //ancestor::div[@class='card mt-4 top-card']")).click();
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
