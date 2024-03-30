package MariusMurgulet;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.skillbrain.BasePageObject;

import java.io.IOException;

public class HerokuappPage extends BasePageObject {

    private static final String HERO_HOME_PAGE= "https://testpages.eviltester.com/styled/index.html";
//    public HerokuappPage(WebDriver chromeDriver) {
//        super();
//    }
    public HerokuappPage(WebDriver driver){
        this.driver = driver;
//        PageFactory.initElements(driver, DemoqaPage.class);
        PageFactory.initElements(driver, this); // echivalent
    }

    @FindBy(id="basicpagetest")
    private WebElement basicWebPage;
    @FindBy(id="elementattributestest")
    private WebElement elementAttributes;
    @FindBy(id="findbytest")
    private WebElement findBytest;
    @FindBy(id="webdriverexamplepage")
    private WebElement webdriverExamplePage;

    @FindBy(id="alerttest")
    private WebElement alerTest;
    @FindBy(id="fakealerttest")
    private WebElement fakeAlertTest;

    public String gotoHeroHomePage(String page) throws InterruptedException {
        //driver.get(HERO_HOME_PAGE);
        driver.get(String.format("http://testpages.eviltester.com/styled/%s.html",page));
        Thread.sleep(500);
        String pageTitle = driver.getTitle(); //herokuappPage.gotoHeroHomePage(page);
        System.out.println("Page title: " + pageTitle);
        String bodyText = driver.findElement(By.tagName("h1")).getText();
        System.out.println("Header text of " + page + ":\n" + bodyText);
        return driver.getTitle();
    }
    public String gotoHeroAlertPage(String page) throws InterruptedException {
        //driver.get(HERO_HOME_PAGE);
        driver.get(String.format("http://testpages.eviltester.com/styled/alerts/%s.html",page));
        Thread.sleep(200);
        return driver.getTitle();
    }
    public void clickBasicWebPageLink(){
        basicWebPage.click();
        WebElement title = driver.findElement(By.xpath("//h1[text()='Basic Web Page Example']"));
        System.out.println(title.getText());
    }
    public void clickElementAttributesLink(){
        elementAttributes.click();
        WebElement element = driver.findElement(By.xpath("//h1[text()='Element Attributes Examples']"));
        System.out.println(element.getText());
    }
    public void clickFindbytest(){
        findBytest.click();
        WebElement findbytest = driver.findElement(By.xpath("//h1[text()='Find By Playground - Locator Examples']"));
        System.out.println(findbytest.getText());
    }
    public void clickWebdriverExamplePage(){
        webdriverExamplePage.click();
        WebElement webdriver = driver.findElement(By.xpath("//h1[text()='Example Page Heading One']"));
        System.out.println(webdriver.getText());
    }

    public void firstAlertTest() throws InterruptedException {
        //alerTest.click();
        WebElement alertTitlePage = driver.findElement(By.xpath("//h1[text()='Alert Box Examples']"));
        System.out.println("You entered on the page with " + alertTitlePage.getText());
        WebElement alertexamples = driver.findElement(By.id("alertexamples"));
        alertexamples.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        Thread.sleep(1000);
        alert.accept();
        WebElement alertexplanation = driver.findElement(By.id("alertexplanation"));
        System.out.println(alertexplanation.getText());
    }
    public void secondAlertTest() throws IOException {
        //alerTest.click();
        try{
            WebElement confirmexample = driver.findElement(By.id("confirmexample"));
            for(int i=0; i<=1; i++){
                confirmexample.click();
                Alert alert = driver.switchTo().alert();
                System.out.println(alert.getText());
                if(i==0){
                    alert.accept();
                }else {
                    alert.dismiss();
                }
                WebElement confirmexplanation = driver.findElement(By.id("confirmexplanation"));
                System.out.println(confirmexplanation.getText());
            }
        }catch (Exception e){
            takeScreenshot(driver);
            e.printStackTrace();
        }
    }
    public void thirdAlertTest() throws IOException{
        //alerTest.click();
        WebElement promptexample = driver.findElement(By.id("promptexample"));
        for(int i=0; i<=1;i++){
            promptexample.click();
            Alert alert = driver.switchTo().alert();
            alert.sendKeys("Marius");
            System.out.println(alert.getText());
            if(i==0){
                alert.accept();
            }else {
                alert.dismiss();
            }
            WebElement promptexplanation = driver.findElement(By.id("promptexplanation"));
            System.out.println(promptexplanation.getText());
        }
    }
    public void fakeAlertTest() throws InterruptedException {
        //fakeAlertTest.click();
        WebElement fakeTitle = driver.findElement(By.xpath("//h1[text()='Fake Alert Box Examples']"));
        System.out.println("You are on the " + fakeTitle.getText() + "page");
        WebElement fakeAlert = driver.findElement(By.id("fakealert"));
        fakeAlert.click();
        WebElement dialogtext = driver.findElement(By.xpath("(//h2[text()='I am a fake alert box!'])"));
        Thread.sleep(500);
        System.out.println(dialogtext.getText());
        WebElement dialogOK = driver.findElement(By.id("dialog-ok"));
        dialogOK.click();
        WebElement modaldialog = driver.findElement(By.id("modaldialog"));
        modaldialog.click();
        WebElement modalDiv = driver.findElement(By.xpath("(//h2[text()='I am a modal div!'])"));
        Thread.sleep(500);
        System.out.println(modalDiv.getText());
    }
}
