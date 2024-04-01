package TimeeaPop.Selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementsTextboxNegative {
    private static ChromeDriver driver;
    public static void main(String[] args) {
        //open chrome + access demoQA
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
        //accept consent
        WebElement consentButton = driver.findElement(By.cssSelector(".fc-button.fc-cta-consent.fc-primary-button"));
        consentButton.click();

        // input field
        String inputName = "Timeea Pop";
        String inputEmail = "notValidEmail";
        String inputCurrentAddress = "Adresa mea, Oradea, Bihor";
        String inputPermanentAddress = "Adresa mea permanenta, Oradea, Bihor, Romania";

        //complete all fields
        WebElement nameField = driver.findElement(By.id("userName"));
        nameField.sendKeys(inputName);
        WebElement emailField = driver.findElement(By.id("userEmail"));
        emailField.sendKeys(inputEmail);
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys(inputCurrentAddress);
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys(inputPermanentAddress);

        //submit completed fields
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
        submitButton.click();

        WebElement emailFieldWithError = driver.findElement(By.xpath("//input[@class='mr-sm-2 field-error form-control']"));
        if (emailFieldWithError.isDisplayed()){
            System.out.println("Invalid email");
        }
        driver.quit();
    }
}
