package TimeeaPop.TestNG721;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class KatalonMainPageObject extends BasePageObject{
    private static final String KATALONAPP_MAIN_PAGE= "https://katalon-demo-cura.herokuapp.com/";

    @FindBy(id = "menu-toggle")
    private WebElement menuButton;

    @FindBy(xpath = "(//a[normalize-space()='Login'])[1]")
    private WebElement loginButton;

    @FindBy(id = "btn-make-appointment")
    private WebElement makeAppointmentButton;

    public void clickOnMakeAppointmentButton(){
        makeAppointmentButton.click();
    }
    public void clickOnMenuButton() {
        menuButton.click();
    }
    public void clickOnLoginButton(){
        loginButton.click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://katalon-demo-cura.herokuapp.com/profile.php#login";
        Assert.assertEquals(currentUrl, expectedUrl, "Successfully landed on login page.");
    }

    public KatalonMainPageObject (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void landOnMainPage(){
        driver.get(KATALONAPP_MAIN_PAGE);
    }

}
