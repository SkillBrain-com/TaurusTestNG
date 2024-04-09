package TimeeaPop.TestNG721;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KatalonLoginPageObject extends BasePageObject{
    private static final String KATALONAPP_LOGIN_PAGE = "https://katalon-demo-cura.herokuapp.com/profile.php#login";
    public void landOnLoginPage(){
        driver.get(KATALONAPP_LOGIN_PAGE);
    }
    public KatalonLoginPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "txt-username")
    private WebElement usernameField;

    @FindBy(id = "txt-password")
    private WebElement passwordField;

    @FindBy(id = "btn-login")
    private WebElement loginButton;

    public void clickOnLoginButton() {
        loginButton.click();
    }
    public void addInvalidPassword() {
        passwordField.click();
        passwordField.sendKeys("qwertyuiop");
    }
    public void addInvalidUsername() {
        usernameField.click();
        usernameField.sendKeys("Timeea Pop");
    }

    public void addValidUsername(){
        usernameField.click();
        usernameField.sendKeys("John Doe");
    }
    public void addValidPassword() {
        passwordField.click();
        passwordField.sendKeys("ThisIsNotAPassword");
    }

    //MAKE AN APPOINTMENT PAGE
    @FindBy(id = "combo_facility")
    private WebElement facilityDropDownButton;
    @FindBy(xpath = "//option[@value='Hongkong CURA Healthcare Center']")
    private WebElement secondFacility;
    public void chooseFacility() throws InterruptedException {
        facilityDropDownButton.click();
        Thread.sleep(2000);
        secondFacility.click();
    }

    @FindBy(id = "radio_program_medicaid")
    private WebElement medicaidRadioButton;
    public void chooseMedicaidHealthcareProgram(){
        medicaidRadioButton.click();
    }

    @FindBy(id = "txt_visit_date")
    private WebElement visitDateCalendar;
    public void selectDateForAppointment(){
        visitDateCalendar.click();
        visitDateCalendar.sendKeys("2/4/2024");
        visitDateCalendar.sendKeys(Keys.ENTER);
    }
    public void checkIfAlertIsDisplayedIfDateIsNotSelected() {
        Actions actions = new Actions(driver);
        actions.moveToElement(visitDateCalendar).perform();
    }

    @FindBy(id = "txt_comment")
    private WebElement addCommentSection;
    public void addAdditionalCommentForAppointment() {
        addCommentSection.click();
        addCommentSection.sendKeys("I would like to make an appointment with Dr. Chan. Thank you! - Timeea");
    }

    @FindBy(id = "btn-book-appointment")
    private WebElement bookAppointmentButton;
    public void clickOnBookAppointmentButton() {
        bookAppointmentButton.click();
    }

    @FindBy(xpath = "//div[@class='col-xs-12 text-center']")
    private WebElement confirmationMessageTitle;
    public void checkConfirmationMessageTitle() {
        confirmationMessageTitle.isDisplayed();
        System.out.println(confirmationMessageTitle.getText());
    }

    @FindBy(xpath = "//div[@class='col-xs-12 text-center']")
    private WebElement bookedFacility;
    public void checkBookedFacility() {
        bookedFacility.isDisplayed();
        System.out.println(bookedFacility.getText());
    }

    @FindBy(id = "menu-toggle")
    private WebElement mainMenuButton;
    public void clickOnMainMenuButton() {
        mainMenuButton.click();
    }

    @FindBy(xpath = "//a[normalize-space()='Home']")
    private WebElement homeButton;
    public void clickOnHomeButton() {
        homeButton.click();
    }
}
