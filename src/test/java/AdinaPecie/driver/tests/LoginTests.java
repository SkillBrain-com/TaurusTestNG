package AdinaPecie.driver.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTest{


    @Test(description = "Verify login scenario with different users", dataProvider = "loginUsers", groups = {"without_login"})
    public void testLoginScenarios(String username, String password, boolean shouldLogin, boolean shouldWait){

        loginSteps(username, password);

        if(shouldLogin) {

            assertTrue(driver.getCurrentUrl().contains("inventory.html"),
                    "User is not taken to the right page after login");
            List<WebElement> inventoryItems = driver.findElements(By.cssSelector(".inventory_item"));
            assertFalse(inventoryItems.isEmpty(), "No items are present after successful login");

            for (WebElement item : inventoryItems) {
                assertTrue(item.isDisplayed(),
                        "Items are not displayed after successful login");
            }
        }else {
            assertFalse(driver.getCurrentUrl().contains("inventory.html"),
                    "User is taken to the items page after login with a user that should not see that page");

            if(shouldWait){
                try{
                    Thread.sleep(5000);
                }catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
            assertTrue(isElementPresent(By.cssSelector("h3[data-test='error']")),
                    "Error message is not present after login with a user that should not see that page");
        }

    }

    @DataProvider
    public Object[][] loginUsers() {
        return new Object[][] {

                {"standard_user","secret_sauce" ,true , false},
                {"locked_out_user","secret_sauce", false, false},
                {"problem_user","secret_sauce", true, false},
                {"performance_glitch_user","secret_sauce", true, true},
        };
    }
}
