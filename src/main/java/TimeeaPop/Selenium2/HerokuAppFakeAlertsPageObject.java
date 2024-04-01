package TimeeaPop.Selenium2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HerokuAppFakeAlertsPageObject extends BasePageObject {
    private static final String FAKEALERT_BOX_EXAMPLES_PAGE = "https://testpages.eviltester.com/styled/alerts/fake-alert-test.html";

    @FindBy(id = "fakealert")
    private WebElement fakeAlertButton;

    @FindBy(xpath = "//div[@role='dialog']")
    private WebElement fakeAlertDialog;

    @FindBy(id = "dialog-ok")
    private WebElement okButtonFromDialog;

    @FindBy(id = "modaldialog")
    private WebElement showModalDialog;

    public void clickOnShowModalDialogButton() {
        showModalDialog.click();
    }

    public void checkFakeDialogAndCloseIt(){
        Assert.assertTrue(fakeAlertDialog.isDisplayed());
        okButtonFromDialog.click();
    }
    public void clickOnFakeAlertButton() {
        fakeAlertButton.click();
    }

    public void landOnFakeAlertsPage() {
        driver.get(FAKEALERT_BOX_EXAMPLES_PAGE);
    }
    public HerokuAppFakeAlertsPageObject (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
