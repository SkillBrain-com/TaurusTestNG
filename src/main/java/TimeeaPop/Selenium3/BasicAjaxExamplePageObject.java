package TimeeaPop.Selenium3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BasicAjaxExamplePageObject extends BasePageObjectS3 {
    private static final String BASIC_AJAX_EXAMPLE_PAGE = "https://testpages.herokuapp.com/styled/basic-ajax-test.html";
    public void landOnBasicAjaxExamplePage(){
        driver.get(BASIC_AJAX_EXAMPLE_PAGE);
    }
    public BasicAjaxExamplePageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "combo1")
    private WebElement categoryList;
    @FindBy(xpath = "//option[normalize-space()='Server']")
    private WebElement serverOptionFromCategoryList;
    public void clickOnCategoryListAndChoose() {
        categoryList.click();
        serverOptionFromCategoryList.click();
    }

    @FindBy(id = "combo2")
    private WebElement languageList;
    @FindBy(xpath = "//option[normalize-space()='Flash']")
    private WebElement flashOptionFromLanguageList;

    public void clickOnLanguageListAndChoose() {
        languageList.click();
        flashOptionFromLanguageList.click();
    }

    @FindBy(xpath = "//input[@name='submitbutton']")
    private WebElement submitButton;

    public void clickOnSubmitButton(){
        submitButton.click();
    }

    //Page elements after submitting results

    public void checkCurrentURL() {
        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://testpages.herokuapp.com/styled/the_form_processor.php?ajax=1";
        Assert.assertEquals(currentURL,expectedURL,"Success");
        System.out.println(currentURL);
    }

    @FindBy(id = "_valueid")
    private WebElement submittedCategoryValue;
    public void checkSubmittedCategory() {
        submittedCategoryValue.isDisplayed();
        System.out.println(submittedCategoryValue.getText());
    }

    @FindBy(id = "_valuelanguage_id")
    private WebElement submittedLanguageValue;
    public void checkSubmittedLanguage() {
        submittedLanguageValue.isDisplayed();
        System.out.println(submittedLanguageValue.getText());
    }

    @FindBy(id = "_valuesubmitbutton")
    private WebElement submittedSubmitButtonValue;
    public void checkSubmittedSubmitButtonValue() {
        submittedSubmitButtonValue.isDisplayed();
        System.out.println(submittedSubmitButtonValue.getText());
    }
}
