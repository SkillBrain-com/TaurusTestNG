package TimeeaPop.Selenium3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class JavaScriptRedirectsPageObject extends BasePageObjectS3 {
    private static final String JAVASCRIPT_REDIRECT_PAGE = "https://testpages.herokuapp.com/styled/javascript-redirect-test.html";
    public void landOnJavaScriptRedirectsPage(){
        driver.get(JAVASCRIPT_REDIRECT_PAGE);
    }
    public JavaScriptRedirectsPageObject (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@onclick='startRedirection(5000)']")
    private WebElement fiveSecondsRedirectButton;
    @FindBy(id = "javascript_countdown_time")
    private WebElement countdownTime;
    public void clickOnFiveSecondsRedirectButton() {
        fiveSecondsRedirectButton.click();
        countdownTime.isDisplayed();
    }

    @FindBy(xpath = "//button[@onclick='startRedirection(2000)']")
    private WebElement twoSecondsRedirectButton;
    public void clickOnTwoSecondsRedirectButton() {
        twoSecondsRedirectButton.click();
        countdownTime.isDisplayed();
    }

    public void checkCurrentURL() {
        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://testpages.herokuapp.com/styled/redirected.html";
        Assert.assertEquals(currentURL,expectedURL,"Success");
        System.out.println(currentURL);
    }

    //redirectedPage

    @FindBy(xpath = "//h1[normalize-space()='Redirect Landing Page']")
    private WebElement titleFromRedirectedPage;
    public void checkTitleFromRedirectedPage() {
        titleFromRedirectedPage.isDisplayed();
        System.out.println(titleFromRedirectedPage.getText());
    }

    @FindBy(xpath = "//p[normalize-space()='You have been successfully redirected.']")
    private WebElement messageFromRedirectedPage;
    public void checkSuccessMessageFromRedirectedPage() {
        messageFromRedirectedPage.isDisplayed();
        System.out.println(messageFromRedirectedPage.getText());
    }
}
