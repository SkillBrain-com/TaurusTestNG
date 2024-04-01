package TimeeaPop.Selenium1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasiscTema1AlertaDemoQA {
    private static ChromeDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");

        WebElement consentButton = driver.findElement(By.cssSelector(".fc-button.fc-cta-consent.fc-primary-button"));
        consentButton.click();
//        driver.findElement(By.id("promtButton")).click();
//        Alert alert = driver.switchTo().alert();
//        alert.sendKeys("Timeea");
//        alert.accept();
//        System.out.println(driver.findElement(By.id("promptResult")).getText());

        driver.findElement(By.id("promtButton")).click();
        Alert alert2 = driver.switchTo().alert();
        alert2.sendKeys("Press Enter");
        alert2.sendKeys(String.valueOf(Keys.RETURN));
        System.out.println(driver.findElement(By.id("promptResult")).getText());

        driver.quit();
    }
}
