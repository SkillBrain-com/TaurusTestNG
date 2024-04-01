package TimeeaPop.Selenium1;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementsTextbox {
    private static ChromeDriver driver;
    public static void main( String[] args ) throws InterruptedException {
        //open chrome + access demoQA
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");

        //accept consent
        WebElement consentButton = driver.findElement(By.cssSelector(".fc-button.fc-cta-consent.fc-primary-button"));
        consentButton.click();

        //access 'Elements' page
        WebElement elements = getCard("Elements");
        elements.click();
        //open textbox
        WebElement textBox = driver.findElement(By.id("item-0"));
        textBox.click();
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        // input field
        String inputName = "Timeea Pop";
        String inputEmail = "timeeatest@pop.com";
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

        //check displayed results
        WebElement nameResult = driver.findElement(By.id("name"));
        String nameDisplayed = String.valueOf(nameResult.getText().split(":")[1]);
        System.out.println(nameDisplayed);

        WebElement emailResult = driver.findElement(By.id("email"));
        String emailDisplayed = String.valueOf(emailResult.getText());
        System.out.println(emailDisplayed);

        WebElement currentAddressResult = driver.findElement(By.xpath("(//p[@id='currentAddress'])[1]"));
        String displayedCurrentAddress =  String.valueOf(currentAddressResult.getText());
        System.out.println(displayedCurrentAddress);

        WebElement permanentAddressResult = driver.findElement(By.xpath("(//p[@id='permanentAddress'])[1]"));
        String displayedPermanentAddress = String.valueOf(permanentAddressResult.getText());
        System.out.println(displayedPermanentAddress);

        // Compare input values with displayed results
        Assert.assertEquals("Name does not match the expected value.", inputName, nameResult.getText().split(":")[1].trim());
        Assert.assertEquals("Email does not match the expected value.", inputEmail, emailResult.getText().split(":")[1].trim());
        Assert.assertEquals("Current Address does not match the expected value.", inputCurrentAddress, currentAddressResult.getText().split(":")[1].trim());
        Assert.assertEquals("Permanent Address does not match the expected value.", inputPermanentAddress, permanentAddressResult.getText().split(":")[1].trim());

        //close drive
        driver.quit();
    }

    private static WebElement getCard(String card) {
        return driver.findElement(By.xpath("//h5[text()='"+ card +"'] //ancestor::div[@class='card mt-4 top-card']"));
    }
}
