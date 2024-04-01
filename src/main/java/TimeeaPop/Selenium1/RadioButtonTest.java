package TimeeaPop.Selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonTest {
    private static ChromeDriver driver;
    public static void main(String[] args) throws Exception {
        //open chrome + access demoQA
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/radio-button");
        //accept consent
        WebElement consentButton = driver.findElement(By.cssSelector(".fc-button.fc-cta-consent.fc-primary-button"));
        consentButton.click();

        driver.findElement(By.className("custom-control-label")).click();
        WebElement messageDisplayed = driver.findElement(By.className("text-success"));
        System.out.println(messageDisplayed.getText());

        driver.findElement(By.xpath("//label[text()='Impressive']")).click();
        System.out.println(messageDisplayed.getText());

        WebElement noButton = driver.findElement(By.id("noRadio"));
        if (noButton.getAttribute("disabled") != null){ //check daca atributul disabled e prezent sau nu, daca exista (adica !=null) inseamna ca button is not clickable
           // <input type="radio" id="noRadio" disabled="" name="like" class="custom-control-input disabled" xpath="1">
            System.out.println("NO button is not clickable");
        } else {
            System.out.println("NO button is clickable");
        }

        driver.quit();

    }

}

