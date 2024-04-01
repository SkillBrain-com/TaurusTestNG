package TimeeaPop.Selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxTest {
    private static ChromeDriver driver;

    public static void main(String[] args) throws Exception{
        //open chrome + access demoQA
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/checkbox");
        //accept consent
        WebElement consentButton = driver.findElement(By.cssSelector(".fc-button.fc-cta-consent.fc-primary-button"));
        consentButton.click();

        driver.findElement(By.xpath("//button[@class='rct-collapse rct-collapse-btn']")).click();
        WebElement expandedListWithThreeMainFolders = driver.findElement(By.xpath("(//li[@class='rct-node rct-node-parent rct-node-expanded'])[1]"));
        expandedListWithThreeMainFolders.isDisplayed();
        System.out.println(expandedListWithThreeMainFolders.getText());

        driver.quit();
    }
}
