package TimeeaPop.Selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ButtonsTest {
    private static ChromeDriver driver;
    public static void main(String[] args) throws Exception{
        //open chrome + access demoQA
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/buttons");
        //accept consent
        WebElement consentButton = driver.findElement(By.cssSelector(".fc-button.fc-cta-consent.fc-primary-button"));
        consentButton.click();

        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickBtn).build().perform();
        System.out.println(driver.findElement(By.id("doubleClickMessage")).getText());

        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClickBtn).build().perform();
        System.out.println(driver.findElement(By.id("rightClickMessage")).getText());

        WebElement dynamicClickBtn = driver.findElement(By.xpath("//button[text()='Click Me']"));
        dynamicClickBtn.click();
        System.out.println(driver.findElement(By.id("dynamicClickMessage")).getText());

        driver.quit();

    }
}
