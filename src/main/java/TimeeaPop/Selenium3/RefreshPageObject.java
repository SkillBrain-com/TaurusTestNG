package TimeeaPop.Selenium3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class RefreshPageObject extends BasePageObjectS3 {
    private static final String REFRESH_PAGE = "https://testpages.herokuapp.com/styled/refresh";
    public void landOnRefreshPage(){
        driver.get(REFRESH_PAGE);
    }
    public RefreshPageObject (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "button")
    private WebElement refreshNowButton;
    public void clickOnRefreshButton() {
        refreshNowButton.click();
    }
    @FindBy(id = "refreshdate")
    private WebElement timestampFromSuccessMessage;
    public void convertTimestampToCurrentTimeAndDate() {
        long unixTimestamp = Long.parseLong(timestampFromSuccessMessage.getText());
        Instant instant = Instant.ofEpochSecond(unixTimestamp);
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.of("UTC"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);
        System.out.println(unixTimestamp);
        System.out.println(formattedDateTime);
    }

}
