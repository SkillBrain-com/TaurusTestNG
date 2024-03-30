package CarmenOltean;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.skillbrain.BasePageObject;

public class KatalonPageObject extends BasePageObject {

    public KatalonPageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private static final String KATALON_HOME_PAGE = "https://katalon-demo-cura.herokuapp.com/";

    @FindBy(id = "menu-toggle")
    private WebElement menuButton;

    @FindBy(xpath = "//a[@href='profile.php#login']")
    private WebElement logInBtn;
    @FindBy(id = "btn-make-appointment")
    private WebElement makeAppointmentBtn;
    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement homeBtn;



    public void langOnKatalon(){
        driver.get(KATALON_HOME_PAGE);
    }
    public void clickOnMenuButton(){
        menuButton.click();
    }
    public void clickOnLogInBtn(){
        logInBtn.click();
    }
    public void makeAppointment(){
        makeAppointmentBtn.click();
    }
    public void enterLoginData(String username, String password){
        WebElement usernameField = driver.findElement(By.id("txt-username"));
        WebElement passwordField = driver.findElement(By.id("txt-password"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        driver.findElement(By.id("btn-login")).click();

    }

    public void clickOnHomeBtn(){
        homeBtn.click();
    }






}
