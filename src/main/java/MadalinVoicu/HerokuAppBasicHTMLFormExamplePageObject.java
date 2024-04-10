package MadalinVoicu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HerokuAppBasicHTMLFormExamplePageObject extends BasePageObject{
    private static final String BASIC_HTML_FORM_EXAMPLE_PAGE = "https://testpages.eviltester.com/styled/basic-html-form-test.html";

    public HerokuAppBasicHTMLFormExamplePageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}