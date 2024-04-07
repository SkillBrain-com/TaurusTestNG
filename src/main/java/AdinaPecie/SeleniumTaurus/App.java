package AdinaPecie.SeleniumTaurus;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrom.driver", "drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://demoqa.com");
//        WebElement consentButton = driver.findElement(By.cssSelector(".fc-button.fc-cta-consent.fc-primary-button"));
//        consentButton.click();
        WebElement header = driver.findElement(By.tagName("header"));
        header.click();
        //  WebElement elementButton = driver.findElement(By.xpath("(//div[@class='card mt-4 top-card'])[1])"));
        //  elementButton.click();
        WebElement elements = getCard("Elements");
        elements.click();
        WebElement textBox = driver.findElement(By.id("item-0"));
        textBox.click();
        WebElement nameField = driver.findElement(By.id("userName"));
        nameField.sendKeys("Ana");
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys("adina@test.com");
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Zimnicea");
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("Zimnicea");

        WebElement buttonSubmit = driver.findElement(By.xpath("//button[text()='Submit']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", buttonSubmit);
        buttonSubmit.click();
        WebElement nameSubmit = driver.findElement(By.id("name"));
        String textName = nameSubmit.getText().split(":")[1];
        System.out.println(textName);

        WebElement emailSubmit = driver.findElement(By.id("email"));
        String textEmail = emailSubmit.getText().split(":")[1];
        System.out.println(textEmail);

        WebElement currentAddress1Submit = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        String textCurrentAddress1 = currentAddress1Submit.getText().split(":")[1];
        System.out.println(textCurrentAddress1);

//        WebElement permanentAddress1Submit = driver.findElement(By.id("permanentAddress"));
//        String textPermanentAddres1 = permanentAddress1Submit.getText().split(":")[1];
//        System.out.println(textPermanentAddres1);

        if (textName.equals("Ana")) {
            System.out.println("Se verifica concordanta la nume");
        } else {
            System.out.println("Nu se verifica concordanta la nume");
        }

        if (textEmail.equals("adina@test.com")) {
            System.out.println("Se verifica concordanta la email");
        } else {
            System.out.println("Nu se verifica concordanta la email");
        }

        if (textCurrentAddress1.equals("Zimnicea,Teleorman")) {
            System.out.println("Se verifica concordanta la adresa curenta");
        } else {
            System.out.println("Nu se verifica concordanta la adresa curenta");
//        }
//
//        if(textPermanentAddres1.equals("Zimnicea,Teleorman")) {
//            System.out.println("Se verifica concordanta la adresa permanenta");
//        } else {
//            System.out.println("Nu se verifica concordanta la adresa permanenta");
//        }


            Thread.sleep(2000);
            driver.quit();
        }
    }


    private static WebElement getCard (String card) {

        return driver.findElement(By.xpath("//h5[text()='" + card + "']//ancestor::div[@class='card mt-4 top-card']"));

    }
}
