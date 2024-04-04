package KateaManoila;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DemoqaPage  {
    static WebDriver driver;

    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://demoqa.com/browser-windows");
            WebElement consentButton = driver.findElement(By.cssSelector(".fc-button.fc-cta-consent.fc-primary-button"));
            consentButton.click();
            WebElement newTabButton = driver.findElement(By.id("tabButton"));
            newTabButton.click();
            Set<String> windowHandles = driver.getWindowHandles();
            Iterator<String> iterator = windowHandles.iterator();
            List<String> windovId = new ArrayList<>();

            while (iterator.hasNext()){
                String id = iterator.next();
                windovId.add(id);
            }
            System.out.println(windovId);


           driver.switchTo().window(windovId.get(1));


            WebElement sampleHeading = driver.findElement(By.id("sampleHeading"));
            System.out.println(sampleHeading.getText());

            driver.switchTo().window(windovId.get(0));
            driver.findElement(By.id("messageWindowButton")).click();


//            WebElement clickMyButton = driver.findElement(By.id("confirmButton"));
//            clickMyButton.click();

//            actionsExample();

//            alertExample();


        } catch (Exception e) {
//            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();

        }


    }

    private static void actionsExample() {
        WebElement clickMyButton = driver.findElement(By.xpath(" //button[text()='Click Me']"));
        Actions actions = new Actions(driver);
//            actions.doubleClick(rightClickButton).build().perform();
//            actions.contextClick(rightClickButton).build().perform();
        actions.click(clickMyButton).build().perform();


        WebElement outcome = driver.findElement(By.tagName("p"));
        System.out.println(outcome.getText());
    }

    private static void alertExample() throws InterruptedException {
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        Thread.sleep(1000);
        WebElement confirmationResult = driver.findElement(By.id("confirmResult"));
        System.out.println(confirmationResult.getText());
    }

    public static void runtimeException() throws RuntimeException {
        throw new RuntimeException();
    }

    private static void exceptionExample() {
        try {

            System.out.println("Running application");
            Thread.sleep(2000);
            throwException();
            System.out.println("Preparing to close");

        } catch (Exception e) {
            System.out.println("There was an error!");
            System.out.println(e.getMessage());

        } finally {
            System.out.println("Finished executing code!");
        }
    }

    public static void throwException() throws Exception {
        throw new Exception("Generic exception");
    }
}
