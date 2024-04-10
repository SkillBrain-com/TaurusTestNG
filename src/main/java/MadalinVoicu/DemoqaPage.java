package MadalinVoicu;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DemoqaPage {

    static WebDriver driver;

    public static void main(String[] args)  {

        try{


            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize(); //cand deschide browserul imi mareste pagina pe tot ecranul
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://demoqa.com/alerts");
            WebElement consentButton = driver.findElement(By.cssSelector(".fc-button-label"));
            consentButton.click();
//            WebElement clickMeButton = driver.findElement(By.id("alertButton"));
//            clickMeButton.click();
//            Alert alert = driver.switchTo().alert();
//            Thread.sleep(3000);
//            alert.accept();
//            Thread.sleep(1000);
            WebElement clickMeButtonTimer = driver.findElement(By.id("timerAlertButton"));
            clickMeButtonTimer.click();
            Thread.sleep(5000);
            Alert alert = driver.switchTo().alert();
            alert.accept();
            Thread.sleep(2000);

        } catch(Exception e){
            System.out.println(e.getMessage());

        } finally {
            driver.quit();
        }






//       try {
//
//           System.out.println("Running app");
//           Thread.sleep(2000);
//           throwException();
//
//           System.out.println("Preparing to close app.");
//           System.out.println("Closing...");
//
//
//       } catch (Exception e){
//           System.out.println("There was an error!");
//           System.out.println(e.getMessage());
////           e.printStackTrace();
//
//       } finally {
//           System.out.println("Finished executing code!");
//       }


    }

    private static void throwException() throws Exception {
        throw new Exception("Generic exception thrown.");
    }

}
