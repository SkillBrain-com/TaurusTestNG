package CarmenOltean;

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
        URL url = new URL("http://192.168.1.6:4444");
        RemoteWebDriver remoteWebDriver = new RemoteWebDriver(url,new ChromeOptions());
        remoteWebDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return remoteWebDriver;

    }



    public WebDriver getChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("C:\\Users\\msluciano\\IdeaProjects\\SeleniumTaurus\\Extensions\\ADblock.crx"));
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }
    public void takeScreenshot(WebDriver driver) throws IOException {
        String destinationFile = null;
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        //destinationFile = "Printscreen/printscreen.png";
        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH-mm-ss"));

        destinationFile = String.format("Printscreen\\printscreen-%s.png", format);
        System.out.println(destinationFile);
        FileUtils.copyFile(source, new File(destinationFile));
    }


}
