package AdinaPecie;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class WebdriverManager {
    public static ChromeDriver getChromeDriverByExecutable() {

       System.setProperty("webdriver.chrome.driver" , "driver/chromedriver.exe");
        return new ChromeDriver();
    }

    public static ChromeDriver getChromeDriverByManager(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public static ChromeDriver getChromeDriverWithOptions () {
        ChromeOptions chromeOptions = new ChromeOptions();

        Map<String, String> map = new HashMap<>();
        map.put("deviceName", "iPhone X");
//        chromeOptions.setExperimentalOption("mobileEmulation",map);
//       se utilizeaza doar in cazul in care cunoastem pagina
//        chromeOptions.setAcceptInsecureCerts(true);
//        pentru a se deschide cu un anume profil ex Profile 1
//        chromeOptions.addArguments("user-data-dir=C:\\Users\\Adina\\AppData\\Local\\Google\\Chrome\\User Data");
//        chromeOptions.addArguments("profile-directory= Profile 1");
        chromeOptions.addArguments("start-maximized");
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions);

    }
}
