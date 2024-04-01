package TimeeaPop.Selenium1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasiscTema1 {
    private static ChromeDriver driver;

    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testpages.eviltester.com/styled/index.html");
//        //1
//        accessFirstLink();
//        WebElement firstParagraph = driver.findElement(By.id("para1"));
//        System.out.println(firstParagraph.getText());
//        WebElement secondParagraph = driver.findElement(By.id("para2"));
//        System.out.println(secondParagraph.getText());

//        //2
//        accessSecondLink();
//        WebElement paragraphWithAttributes = driver.findElement(By.xpath("(//p[@id='domattributes'])[1]"));
//        System.out.println(paragraphWithAttributes.getText());
//
//        WebElement firstParagrapghWithDynamicAttributes = driver.findElement(By.id("jsattributes"));
//        //String firstValue = String.valueOf(firstParagrapghWithDynamicAttributes);
//        System.out.println(firstParagrapghWithDynamicAttributes.getText());
//        WebElement buttonDynamicAttributes = driver.findElement(By.xpath("//button[@class='styled-click-button']"));
//        buttonDynamicAttributes.click();
//        System.out.println(firstParagrapghWithDynamicAttributes.getText());
//        //String secondValue = String.valueOf(firstParagrapghWithDynamicAttributes);
//
////        if (firstValue == secondValue){
////            System.out.println(firstParagrapghWithDynamicAttributes.getText());
////        } else {
////            System.out.println("fail");
////        }
//
//        WebElement secondParagrapghWithDynamicAttributes = driver.findElement(By.id("jsautoattributes"));
//        System.out.println(secondParagrapghWithDynamicAttributes.getText()); //cum le putem diferentia pe cele doua cand au acelasi text?
//

//        //3
//        accessThirdLink();
//        System.out.println(driver.findElement(By.xpath("//p[@name='pName1']")).getText());
//        System.out.println(driver.findElement(By.xpath("//p[@name='pName2']")).getText());
//        System.out.println(driver.findElement(By.xpath("//p[@name='pName3']")).getText());
//        System.out.println("First nested para: " + driver.findElement(By.id("p26")).getText());
//        WebElement fourthNestedParagraph = driver.findElement(By.xpath("//div[@id='div4']"));
//        System.out.println(fourthNestedParagraph.getText());
//        WebElement link1 = driver.findElement(By.id("a27"));
//        link1.click();
//        String getUrl = driver.getCurrentUrl();
//        System.out.println("This is the current link:" + getUrl);
//        WebElement link2 = driver.findElement(By.id("a45"));
//        link2.click();
//        String getSecondUrl = driver.getCurrentUrl();
//        System.out.println("This is the current link:" + getSecondUrl);

        //4
        accessFourthLink();
        driver.findElement(By.id("clickable-link")).click();
        String getUrl = driver.getCurrentUrl();
        System.out.println("This is the current link:" + getUrl);
        WebElement meesageDisplayed = driver.findElement(By.id("message"));
        System.out.println(meesageDisplayed.getText());

        WebElement numberField = driver.findElement(By.id("numentry"));
        numberField.sendKeys("3");
        numberField.sendKeys("4");
        WebElement processOnSeverButton = driver.findElement(By.id("submit-to-server"));
        processOnSeverButton.click();
        String getSecondUrl = driver.getCurrentUrl();
        System.out.println("This is the current link:" + getSecondUrl);
        WebElement secondMessageDisplayed = driver.findElement(By.id("message"));
        System.out.println(secondMessageDisplayed.getText());

        driver.findElement(By.id("show-as-alert")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        driver.quit();

    }

    private static void accessFirstLink() {
        WebElement basicpagetest = driver.findElement(By.id("basicpagetest"));
        basicpagetest.click();
        String getUrl = driver.getCurrentUrl();
        System.out.println("This is the current link you accessed:" + getUrl);
    }

    private static void accessSecondLink() {
        WebElement elementAttributesTest = driver.findElement(By.id("elementattributestest"));
        elementAttributesTest.click();
        String getUrl = driver.getCurrentUrl();
        System.out.println("This is the current link you accessed:" + getUrl);
    }

    private static void accessThirdLink() {
        WebElement locatorsTest = driver.findElement(By.xpath("//a[@href=\"find-by-playground-test.html\"]"));
        locatorsTest.click();
        String getUrl = driver.getCurrentUrl();
        System.out.println("This is the current link you accessed:" + getUrl);
    }

    private static void accessFourthLink() {
        WebElement webDriverExamplePage = driver.findElement(By.id("webdriverexamplepage"));
        webDriverExamplePage.click();
        String getUrl = driver.getCurrentUrl();
        System.out.println("This is the current link you accessed:" + getUrl);
    }
}
