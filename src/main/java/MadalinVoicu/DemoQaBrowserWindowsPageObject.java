package MadalinVoicu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;


public class DemoQaBrowserWindowsPageObject extends BasePageObject{
    private static final String DEMOQA_BROWSE_WINDOW_PAGE = "https://demoqa.com/browser-windows";

    @FindBy(css=".fc-button.fc-cta-consent.fc-primary-button")
    private WebElement consentButton;

    @FindBy(id = "tabButton")
    private WebElement newTabButton;

    @FindBy(id = "windowButton")
    private WebElement newWindowButton;

    @FindBy(id = "messageWindowButton")
    private WebElement newWindowMessageButton;

    @FindBy(id = "sampleHeading")
    private WebElement sampleHeading;

    @FindBy(xpath = "/html/body/text()")
    private WebElement textFromNewWindow;

    public void getHeadingFromNewTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        // Check if there are more than one tab open
        if (tabs.size() > 1) {
            // Switch to the new tab
            driver.switchTo().window(tabs.get(1));
            // Extract the actual heading text
            String actualHeadingText = sampleHeading.getText();
            Assert.assertEquals(actualHeadingText, "This is a sample page", "Heading text mismatch");
            System.out.println("Heading from new tab: " + sampleHeading.getText());
        } else {
            Assert.fail("No new tab found to switch to");
        }
    }

    public void waitForNewWindowToOpen(String currentWindowHandle) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000)); // Adjust timeout as needed
        wait.until(ExpectedConditions.numberOfWindowsToBe(2)); // Waits until two windows are available
    }
    public void getHeadingFromNewWindow() {
        String currentWindowHandle = driver.getWindowHandle();
        waitForNewWindowToOpen(currentWindowHandle);
        Set<String> allWindowHandles = driver.getWindowHandles();
        String newWindowHandle = "This is a sample page";
        for (String handle : allWindowHandles) {
            if (!handle.equals(currentWindowHandle)) {
                newWindowHandle = handle;
                break;
            }
        }
        driver.switchTo().window(newWindowHandle);
        String actualHeadingText = sampleHeading.getText();
        Assert.assertEquals(actualHeadingText, "This is a sample page", "Heading text mismatch");
        System.out.println("Heading from new window: " + sampleHeading.getText());
    }

    public void getMessageFromNewWindow() {
        String currentWindowHandle = driver.getWindowHandle();
        waitForNewWindowToOpen(currentWindowHandle);
        Set<String> allWindowHandles = driver.getWindowHandles();
        String newWindowHandle = "This is a sample page";
        for (String handle : allWindowHandles) {
            if (!handle.equals(currentWindowHandle)) {
                newWindowHandle = handle;
                break;
            }
        }
        driver.switchTo().window(newWindowHandle);
        String actualHeadingText = textFromNewWindow.getText();
        Assert.assertEquals(actualHeadingText, "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.", "Heading text mismatch");
        System.out.println("Heading from new window: " + sampleHeading.getText());
    }

    public void clickOnNewWindowMessageButton() { newWindowMessageButton.click(); }
    public void clickOnNewWindowButton() { newWindowButton.click(); }
    public void clickOnNewTabButton() { newTabButton.click(); }
    public void clickOnConsentButton() {
        consentButton.click();
    }
    public void landOnDemoqaBrowserWindowPage(){
        driver.get(DEMOQA_BROWSE_WINDOW_PAGE);
    }

    public DemoQaBrowserWindowsPageObject (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
