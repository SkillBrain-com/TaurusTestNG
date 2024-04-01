package TimeeaPop.Selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksTest {
    private static ChromeDriver driver;
    public static void main(String[] args) throws Exception{
        //open chrome + access demoQA
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/links");
        //accept consent
        WebElement consentButton = driver.findElement(By.cssSelector(".fc-button.fc-cta-consent.fc-primary-button"));
        consentButton.click();

        WebElement dynamicLink = driver.findElement(By.id("dynamicLink"));
        dynamicLink.click();

       // String mainWindowHandle = driver.getWindowHandle();

        int numberOfTabs = driver.getWindowHandles().size();
        if (numberOfTabs > 1) {
            System.out.println("The link opened a new tab.");
            System.out.println("Number of tabs opened:" + numberOfTabs);
            //driver.switchTo().window(mainWindowHandle);
        } else {
            System.out.println("The link did not open a new tab.");
        }



        //2 Links with API response - not successful
        driver.findElement(By.id("created")).click();
        WebElement responseMessage = driver.findElement(By.id("linkResponse"));
        System.out.println(responseMessage.getText());
//
//        driver.findElement(By.id("no-content")).click();
//        System.out.println(responseMessage.getText());

        driver.quit();
    }
}
