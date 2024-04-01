package TimeeaPop.Selenium2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HerokuAppBasicHTMLFormExamplePageObject extends BasePageObject {
    private static final String BASIC_HTML_FORM_EXAMPLE_PAGE = "https://testpages.eviltester.com/styled/basic-html-form-test.html";

    public void landOnBasicHTMLFormExamplePage() {
        driver.get(BASIC_HTML_FORM_EXAMPLE_PAGE);
    }

    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameField;
    public void clickAndCompleteUsernameField() {
        usernameField.click();
        usernameField.sendKeys("Timeeatest");
    }

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;
    public void clickAndCompletePasswordField() {
        passwordField.click();
        passwordField.sendKeys("tst123456789");
    }

    @FindBy(xpath = "//textarea[@name='comments']")
    private WebElement textAreaComment;
    public void clickAndCompleteTextAreaCommentField() {
        textAreaComment.click();
        textAreaComment.clear();
        textAreaComment.sendKeys("test comm");
    }

    @FindBy(xpath = "//input[@value='cb1']")
    private WebElement checkBoxOne;

    @FindBy(xpath = "//input[@value='cb2']")
    private WebElement checkBoxTwo;

    @FindBy(xpath = "//input[@value='cb3']")
    private WebElement checkBoxThree;

    public void selectFirstCheckBox() {
        checkBoxOne.click();
    }
    public void selectSecondCheckBox() {
        checkBoxTwo.click();
    }
    public void selectThirdCheckBox() {
        checkBoxThree.click();
    }

    @FindBy(xpath = "//input[@value='rd1']")
    private WebElement firstRadioButton;
    public void selectFirstRadioButton() {
        firstRadioButton.click();
    }

    @FindBy(xpath = "//input[@value='rd2']")
    private WebElement secondRadioButton;
    public void selectSecondRadioButton() {
        secondRadioButton.click();
    }

    @FindBy(xpath = "//input[@value='rd3']")
    private WebElement thirdRadioButton;
    public void selectThirdRadioButton() {
        thirdRadioButton.click();
    }

    @FindBy(xpath = "//input[@value='submit']")
    private WebElement submitButton;
    public void clickOnSubmitButton() {
        submitButton.click();
    }

    //SubmittedValues Page
    @FindBy(id = "_valueusername")
    private WebElement submittedUsername;
    public void checkSubmittedUsername(){
        submittedUsername.isDisplayed();
        System.out.println(submittedUsername.getText());
        String getWrittenUsername = submittedUsername.getText();
        Assert.assertTrue(getWrittenUsername.equals("Timeeatest"));
    }

    @FindBy(id = "_valuepassword")
    private WebElement submittedPassword;
    public void checkSubmittedPassword() {
        submittedPassword.isDisplayed();
        System.out.println(submittedPassword.getText());
        String getSubmittedPassword = submittedPassword.getText();
        Assert.assertTrue(getSubmittedPassword.equals("tst123456789"));
    }

    @FindBy(id = "_valuecomments")
    private WebElement submittedComment;
    public void checkSubmittedComment() {
        submittedComment.isDisplayed();
        System.out.println(submittedComment.getText());
        String getSubmittedComment = submittedComment.getText();
        Assert.assertTrue(getSubmittedComment.equals("test comm"));
    }

    @FindBy(id = "_valuecheckboxes0")
    private WebElement submittedFirstCheckBox;
    public void checkSubmittedFirstCheckBox() {
        submittedFirstCheckBox.isDisplayed();
        System.out.println(submittedFirstCheckBox.getText());
        String getSubmittedFirstCheckBox = submittedFirstCheckBox.getText();
        Assert.assertTrue(getSubmittedFirstCheckBox.equals("cb1"));
    }

    @FindBy(id = "_valuecheckboxes1")
    private WebElement submittedSecondCheckBox;
    public void checkSubmittedSecondCheckBox() {
        submittedSecondCheckBox.isDisplayed();
        System.out.println(submittedSecondCheckBox.getText());
        String getSubmittedSecondCheckBox = submittedSecondCheckBox.getText();
        Assert.assertTrue(getSubmittedSecondCheckBox.equals("cb2"));
    }

    @FindBy(id = "_valuecheckboxes2")
    private WebElement submittedThirdCheckBox;
    public void checkSubmittedThirdCheckBox() {
        submittedThirdCheckBox.isDisplayed();
        System.out.println(submittedThirdCheckBox.getText());
        String getSubmittedThirdCheckBox = submittedThirdCheckBox.getText();
        Assert.assertTrue(getSubmittedThirdCheckBox.equals("cb3"));
    }

    @FindBy(id = "_valueradioval")
    private WebElement submittedRadioButton;
    public void checkSubmittedRadioButton() {
        submittedRadioButton.isDisplayed();
        System.out.println(submittedRadioButton.getText());
        String getSubmittedRadioButton = submittedRadioButton.getText();
        Assert.assertTrue(getSubmittedRadioButton.equals("rd1"));
    }
    public HerokuAppBasicHTMLFormExamplePageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
