package sanduCristian;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {

    private static ChromeDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        WebElement header = driver.findElement(By.tagName("header"));
        WebElement consentButton = driver.findElement(By.cssSelector(".fc-button.fc-cta-consent.fc-primary-button"));
        consentButton.click();
        WebElement elements = getCard("Elements");
        elements.click();
        Thread.sleep(2000);
        WebElement textBox = driver.findElement(By.id("item-0"));

        // Scroll to the element using JavaScript Executor
        JavascriptExecutor js = (JavascriptExecutor) driver;


        textBox.click();
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        Thread.sleep(2000);
        WebElement nameField = driver.findElement(By.id("userName"));
        nameField.sendKeys("Ana");
        WebElement emailField = driver.findElement(By.id("userEmail"));
        emailField.sendKeys("test@test.com");
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("safaiufhgafhaufy78w38rhy8");
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("dovhudghdsihgis");
        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
        js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
        submitButton.click();
        Thread.sleep(5000);

        driver.quit();
    }

    private static WebElement getCard(String card) {
        return driver.findElement(By.xpath("//h5[text()='" + card + "']  //ancestor::div[@class='card mt-4 top-card']"));
    }
}