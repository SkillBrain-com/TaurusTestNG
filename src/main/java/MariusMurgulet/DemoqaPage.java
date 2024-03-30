package MariusMurgulet;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class DemoqaPage {
    static WebDriver driver;

    public static void main(String[] args) throws Exception {

        try {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//            WebElement consentButton = driver.findElement(By.cssSelector(".fc-button.fc-cta-consent.fc-primary-button"));
//            consentButton.click();
            windows();
//            actionsExample();
//           alertExample();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            driver.quit();
        }
        //exception
        //IOException ->FileNotFoundException

//        Thread.sleep(2000);
//        throw new IOException("Error");
//        try {
//            System.out.println("Running application");
//            Thread.sleep(2000);
//            throwException();
//            System.out.println("Preparing to close application");
//            System.out.println("Closing");
//        }catch (Exception e){
//            System.out.println("There was an error");
//            System.out.println(e.getMessage());
//            //e.printStackTrace();
//        }
//        finally {
//            System.out.println("Finished executing code.");
//        }
//    }
//
//    public static void throwException() throws Exception {
//        throw new Exception("Generic exception thrown");

    }

    private static void windows() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        newTabButton.click();
        Set<String> windowHandles = driver.getWindowHandles();

        Iterator<String> iterator = windowHandles.iterator();
        ArrayList<String> windowId = new ArrayList<>();
//        List<String> collect = new ArrayList<>(windowHandles); // convert set to arrayList
//        System.out.println(collect);
        while (iterator.hasNext()) {
            String id = iterator.next();
            windowId.add(id);
        }
        System.out.println(windowId);
        driver.switchTo().window(windowId.get(1));
        //Playwright - JS, Java
        //Appium - java testare mobila
        WebElement sampleHeading = driver.findElement(By.id("sampleHeading"));
        sampleHeading.click();
        System.out.println(sampleHeading.getText());

        driver.switchTo().window(windowId.get(0));
        WebElement newWindowButton = driver.findElement(By.id("windowButton"));
        newWindowButton.click();
        driver.switchTo().window(windowId.get(1));
        WebElement sampleHeading2 = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
        System.out.println(sampleHeading2.getText());

        driver.switchTo().window(windowId.get(0));
        driver.findElement(By.id("messageWindowButton")).click();
        //driver.switchTo().window(windowId.get(1));
        driver.switchTo().newWindow(WindowType.WINDOW);
        Thread.sleep(3000);
//        driver.switchTo().window(windowId.get(1));
        String body = driver.findElement(By.xpath("//html")).getText();
        System.out.println(body);
    }

    private static void actionsExample() {
        driver.get("https://demoqa.com/buttons");
        WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickButton).build().perform();
        WebElement outcomeDblClick = driver.findElement(By.id("doubleClickMessage"));
        System.out.println(outcomeDblClick.getText());
        WebElement rightClickButton = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClickButton).build().perform();
        WebElement outcomeRightClick = driver.findElement(By.id("rightClickMessage"));
        System.out.println(outcomeRightClick.getText());
        WebElement clickMeButton = driver.findElement(By.xpath("//button[text()='Click Me']"));
        actions.click(clickMeButton).build().perform();
        WebElement clickMeMessage = driver.findElement(By.xpath("//p[@id='dynamicClickMessage']"));
        System.out.println(clickMeMessage.getText());
    }


    private static void alertExample() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        WebElement clickButton = driver.findElement(By.id("alertButton"));
        clickButton.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        Thread.sleep(1000);
        alert.accept();
        Thread.sleep(1000);
        WebElement clickMeButtonTimer = driver.findElement(By.id("timerAlertButton"));
        clickMeButtonTimer.click();
        Thread.sleep(5000);
        System.out.println(alert.getText());
        alert.accept();
        WebElement confirmButton = driver.findElement(By.id("confirmButton"));
        confirmButton.click();
        Thread.sleep(1000);
        alert.accept();
        Thread.sleep(1000);
        WebElement confirmationResult = driver.findElement(By.id("confirmResult"));
        System.out.println(confirmationResult.getText());
        WebElement promptedButton = driver.findElement(By.id("promtButton"));
        promptedButton.click();
        Thread.sleep(2000);
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("Marius Murgulet");
        promptAlert.accept();
        WebElement promptResult = driver.findElement(By.id("promptResult"));
        System.out.println(promptResult.getText());
    }
}
