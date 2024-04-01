package TimeeaPop.Selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablesTest {
    private static ChromeDriver driver;
    public static void main(String[] args) throws Exception{
        //open chrome + access demoQA
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/webtables");
        //accept consent
        WebElement consentButton = driver.findElement(By.cssSelector(".fc-button.fc-cta-consent.fc-primary-button"));
        consentButton.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");

        //add new
        driver.findElement(By.id("addNewRecordButton")).click();
        driver.findElement(By.xpath("//div[@class='modal-content']")).isDisplayed();
        driver.findElement(By.id("firstName")).sendKeys("Timeea");
        driver.findElement(By.id("lastName")).sendKeys("Pop");
        driver.findElement(By.id("userEmail")).sendKeys("test.timeea@pop.com");
        driver.findElement(By.id("age")).sendKeys("24");
        driver.findElement(By.id("salary")).sendKeys("12345678");
        driver.findElement(By.id("department")).sendKeys("Postings");
        driver.findElement(By.id("submit")).click();
        System.out.println(driver.findElement(By.xpath("(//div[@class='rt-tr-group'])[4]")).getText());

        System.out.println("----------------------------");

        //search after input, modify it then delete it - ok ish
        driver.findElement(By.id("searchBox")).sendKeys("alden");
        driver.findElement(By.id("basic-addon2")).click();
        System.out.println(driver.findElement(By.xpath("(//div[@role='rowgroup'])[1]")).getText());

        System.out.println("----------------------------");

        driver.findElement(By.id("edit-record-2")).click();
        driver.findElement(By.xpath("//div[@class='modal-content']")).isDisplayed();
        driver.findElement(By.id("age")).clear();
        driver.findElement(By.id("age")).sendKeys("50");
        driver.findElement(By.id("submit")).click();
        System.out.println(driver.findElement(By.xpath("(//div[@class='rt-tr-group'])[1]")).getText());

        System.out.println("----------------------------");

        driver.findElement(By.id("delete-record-2")).click();
        WebElement firstRow = driver.findElement(By.xpath("(//div[@class='rt-tr-group'])[1]"));
        System.out.println("Elements displayed after row was deleted:" + firstRow.getText());//better way to do it?

        driver.quit();
    }
}
