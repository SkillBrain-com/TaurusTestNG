package MadalinVoicu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class App 
{

    private static ChromeDriver driver;

    public static void main( String[] args ) throws InterruptedException {

    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize(); //cand deschide browserul imi mareste pagina pe tot ecranul
    driver.get("https://demoqa.com/");
    WebElement header = driver.findElement(By.tagName("header"));
    WebElement consentButton = driver.findElement(By.cssSelector(".fc-button-label"));
    consentButton.click();
//    WebElement elementsCard = driver.findElement(By.xpath("(//div[@class='card mt-4 top-card'])[1]"));
//    elementsCard.click();

        WebElement elements = getCard("Elements");
        elements.click();

        Thread.sleep(2000);
        //Thread nu e indicat sa il folosim pt ca pune pe pauza tot proiectul,
        // nu doar locul in care dorim noi sa ia o pauza
        // e mai cand facem debugging
        WebElement textBox = driver.findElement(By.id("item-0"));
        textBox.click();
        Thread.sleep(2000);

        // fill in user data
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Madalin Voicu");

        WebElement insertedUserEmail = driver.findElement(By.id("userEmail"));
        insertedUserEmail.sendKeys("test@mail.com");

        WebElement insertedCurrentAddress = driver.findElement(By.id("currentAddress"));
        insertedCurrentAddress.sendKeys("adresa curenta");

        WebElement insertedPermanentAddress = driver.findElement(By.id("permanentAddress"));
        insertedPermanentAddress.sendKeys("adresa permanenta");

        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
        Thread.sleep(3000);
        submitButton.click();

        // verify if the inserted user data is correct
        WebElement displayedName = driver.findElement(By.xpath("//p[@id='name']"));
        String resultedName = String.valueOf(displayedName.getText());
        System.out.println(resultedName);

        WebElement displayedUserEmail = driver.findElement(By.xpath("//p[@id='email']"));
        String resultedUserEmail = String.valueOf(displayedUserEmail.getText());
        System.out.println(resultedUserEmail);

        WebElement displayedCurrentAddress = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        String resultedCurrentAddress = String.valueOf(displayedCurrentAddress.getText());
        System.out.println(resultedCurrentAddress);

        WebElement displayedPermanentAddress = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        String resultedPermanentAddress = String.valueOf(displayedPermanentAddress.getText());
        System.out.println(resultedPermanentAddress);

        String currentUrl = driver.getCurrentUrl();
    System.out.println(currentUrl);
//    clickHeaderTestCase(header);




//    clickHeaderTestCase(header, consentButton);


        driver.quit();
}


    private static WebElement getCard(String card){


        return driver.findElement(By.xpath("//h5[text()='" + card + "'] //ancestor::div[@class='card mt-4 top-card']"));
    }

    private static void clickHeaderTestCase(WebElement header) {
        header.click();

    }
}