package AdinaPecie;

import PageObjects.DemoQAPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Set;


@Test
public class MainSelenium {

    private static void windowHandlers(){
        ChromeDriver driver = null;
        try {
            driver.get("https://demoqa.com/browser-windows");
            WebElement tabButton = driver.findElement(By.id("tabButton"));
            tabButton.click();

            String parentWindow = driver.getWindowHandle();
            Set<String> windowHandles = driver.getWindowHandles();

            for (String window: windowHandles) {
                if (!window.equals(parentWindow)){
                    driver.switchTo().window(window);
                    break;

                }
            }
            System.out.println(driver.findElement(By.id("sampleHeading")).getText());
            driver.close();

            driver.switchTo().window(parentWindow);
            driver.findElement(By.id("windowButton")).click();
            Set<String> windowHandles2 = driver.getWindowHandles();
            for (String window: windowHandles2) {
                if (!window.equals(parentWindow)) {
                    driver.switchTo().window(window);
                    break;
                }
            }

            System.out.println(driver.findElement(By.id("sampleHeading")).getText());
            driver.close();

            System.out.println("Finish");
        }finally{
            if (driver != null) {
                driver.quit();
            }
        }

    }
    private static void radioButtons(){
        ChromeDriver driver = null;
        driver.get("https://demoqa.com/radio-button");

        WebElement yesRadioButton = driver.findElement(By.id("yesRadio"));
        WebElement noRadioButton = driver.findElement(By.id("noRadio"));
        WebElement yesRadioButtonLabel = driver.findElement(By.cssSelector("label[for=\"yesRadio\"]"));

        System.out.println("YesRadioButton before click: is Enabled" + yesRadioButton.isEnabled() + ", is Selected: " + yesRadioButton.isSelected());
        System.out.println("NoRadioButton before click: is Enabled" + noRadioButton.isEnabled() + ", is Selected: " + noRadioButton.isSelected());

        driver.executeScript("arguments[0].click()" , yesRadioButton);
        driver.executeScript("arguments[0].click()" , noRadioButton);
//            yesRadioButtonLabel.click();

        System.out.println("YesRadioButton after click: is Enabled" + yesRadioButton.isEnabled() + ", is Selected: " + yesRadioButton.isSelected());
        System.out.println("NoRadioButton after click: is Enabled" + noRadioButton.isEnabled() + ", is Selected: " + noRadioButton.isSelected());

        driver.close();

    }
    private static void alerts (){
        ChromeDriver driver = null;

        driver.get("Https://demoqa.com/alerts");

        WebElement firstButton = driver.findElement(By.id("alertButton"));
        WebElement thirdButton = driver.findElement(By.cssSelector("#confirmButton"));
        WebElement fourthButton = driver.findElement(By.cssSelector("#promtButton"));

//          simple alert -> accept (OK button)
        firstButton.click();
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();

//          alert with OK and Cancel
        thirdButton.click();
        Alert alert2 = driver.switchTo().alert();
        alert2.accept();
        thirdButton.click();
        alert2.dismiss();

        //alert with text input
        fourthButton.click();
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys("Text 2");
        alert3.accept();
        fourthButton.click();
        alert3.sendKeys("Text123q4rwe4");
        alert3.dismiss();

        driver.close();
    }


    private static void simpleClick (){
        ChromeDriver driver = WebdriverManager.getChromeDriverByExecutable();
        driver.get("https://demoqa.com/buttons");
        driver.findElements(By.cssSelector(".btn.btn-primary")).get(2).click();
        driver.quit();


    }

    private static void actionsClass () throws IOException {

            ChromeDriver driver = null;

            try {
                driver.get("https://demoqa.com");

                DemoQAPage demoQAPage = new DemoQAPage(driver);
                List<WebElement> cards = demoQAPage.getCards();
                WebElement sixthCard = cards.get(5);

                Actions actions = new Actions(driver);
                actions.moveToElement(sixthCard).build().perform();

                sixthCard.click();

            }finally{
                if (driver != null) {
                    driver.quit();
                }
            }
    }

    private static void exemplyLocators(WebDriver driver){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();

//        ChromeDriver driver = getChromeDriverByExecutable();
//        driver.get("https://demoqa.com/buttons");

//        try {
        //buttons

//            WebElement clickMeButton = driver.findElement(By.xpath("//button[text()='Click Me']"));
//           sau
//
//            driver.findElements(By.cssSelector(".btn.btn-primay")).get(2).click();
//            Actions actions = new Actions(driver);
//            actions.moveToElement(clickMeButton).build().perform();
//            clickMeButton.click();


//        } catch (Exception E) {
//            System.out.println("Am intrat in ramura de catch");
//            if (driver != null) {
//                File file = driver.getScreenshotAs(OutputType.FILE);
//                File destFile = new File("C:\\Users\\adina\\Desktop\\poza.png");
//                FileUtils.copyFile(file, destFile);
//
//            }
//        } finally {
//            if (driver != null) {
//
//                driver.quit();

        WebElement element1 = driver.findElement(By.xpath("//div[@class='home-banner']"));
//        element1.click();
//        WebElement element2 = driver.findElement(By.cssSelector("div.home-banner a"));
//        element2.click();

        // By.tagName
//        WebElement header = driver.findElement(By.tagName("header"));
//        header.click();

        //By.id
//        driver.get("https://demoqa.com/webtables");
//        WebElement addNewRecordButton = driver.findElement(By.id("addNewRecordButton"));
//        addNewRecordButton.click();

        //By.linkText
//        driver.get("https://demoqa.com/links");
//        WebElement homeButton = driver.findElement(By.linkText("Home"));
//        WebElement partialLink = driver.findElement(By.partialLinkText("content"));
//        partialLink.click();
//        homeButton.click();

        //BY.name
//        driver.get("https://demoqa.com");
//        WebElement meta = driver.findElement(By.name("viewport"));
//        System.out.println(meta.getAttribute("content"));


        //By.className
//        driver.get("https://demoqa.com");
//        driver.findElement(By.className("banner-image")).click();

//        System.out.println("Finish");
//        driver.close();
//          driver.quit();

//            }
//        }

    }



   }

