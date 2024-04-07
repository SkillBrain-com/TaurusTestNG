package AdinaPecie.CursSelenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BasePageObject {
    protected WebDriver driver;

    public RemoteWebDriver getRemoteDriver() throws MalformedURLException {
        URL url = new URL("http://localhost:4444");
        return new RemoteWebDriver(url, new ChromeOptions());
    }

    public WebDriver getChromeDriver () {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrom.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        return driver ;
    }

    public WebDriver getDriver() {
        return driver;
    }
    public void takeScreenshot(WebDriver driver) throws IOException {
        String destinationFile = null;
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        //destinationFile = "Printscreen/printscreen.png";
        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH-mm-ss"));

        destinationFile = String.format("printscreen\\printscreen-%s.png", format);
        System.out.println(destinationFile);
        FileUtils.copyFile(source, new File(destinationFile));
    }

}
