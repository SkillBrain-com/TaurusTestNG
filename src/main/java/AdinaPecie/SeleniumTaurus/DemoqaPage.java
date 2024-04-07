package AdinaPecie.SeleniumTaurus;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DemoqaPage {
    static WebDriver driver;

    public static void main(String[] args) {

        try {
            System.setProperty("webdriver.chrom.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://demoqa.com/buttons");
//            WebElement consentButton = driver.findElement(By.cssSelector(".fc-button.fc-cta-consent.fc-primary-button"));
//            consentButton.click();
//            alerts();
            actions();

            WebElement tabButton = driver.findElement(By.id("tabButton"));
            tabButton.click();
//            System.out.println(driver.getWindowHandle());
            Set<String> windowHandles = driver.getWindowHandles();
            List<String> windowId = new ArrayList<>(windowHandles);
            System.out.println(windowId);
            driver.switchTo().window(windowId.get(1));

            WebElement sampleHeading = driver.findElement(By.id("sampleHeading"));
            System.out.println(sampleHeading.getText());
            driver.switchTo().window(windowId.get(0));


        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally {
            driver.quit();

        }
    }

    private static void actions() {
        Actions actions = new Actions(driver);
        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        actions.doubleClick(doubleClickBtn).build().perform();
        WebElement doubleClickMessage = driver.findElement(By.id("doubleClickMessage"));
        System.out.println(doubleClickMessage.getText());

        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClickBtn).build().perform();
        WebElement rightClickMessage = driver.findElement(By.id("rightClickMessage"));
        System.out.println(rightClickMessage.getText());

        WebElement clickMeButton = driver.findElement(By.xpath("//button[text()='Click Me']"));
        actions.click(clickMeButton).build().perform();
        WebElement dynamicClickMessage = driver.findElement(By.id("dynamicClickMessage"));
        System.out.println(dynamicClickMessage.getText());
    }

    private static void alerts() throws InterruptedException {

        WebElement alertButton = driver.findElement(By.id("alertButton"));
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(2000);

        WebElement timerAlertButton = driver.findElement(By.id("timerAlertButton"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", timerAlertButton);
        timerAlertButton.click();
        Thread.sleep(5000);
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();

        WebElement confirmButton = driver.findElement(By.id("confirmButton"));
        confirmButton.click();
        Alert alert2 = driver.switchTo().alert();
        alert2.dismiss();
        WebElement confirmResult = driver.findElement(By.id("confirmResult"));
        System.out.println(confirmResult.getText());

        WebElement promptButton = driver.findElement(By.id("promtButton"));
        promptButton.click();
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys("Adina");
        alert3.accept();
        WebElement promptResult = driver.findElement(By.id("promptResult"));
        System.out.println(promptResult.getText());
    }
}
