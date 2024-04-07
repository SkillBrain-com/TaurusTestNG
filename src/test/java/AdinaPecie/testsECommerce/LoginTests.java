package AdinaPecie.testsECommerce;

import ECommerce.pageObjects.LoginPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTest {


@Test(description = "Verify login is successful with a correct username and password")
public void testValidLogin(){
    driver.get("https://admin-demo.nopcommerce.com");
    LoginPage loginPage = new LoginPage(driver);
    loginPage.getEmail().clear();
    loginPage.getEmail().sendKeys("admin@yourstore.com");
    loginPage.getPassword().clear();
    loginPage.getPassword().sendKeys(("admin"));
    loginPage.getForm().submit();
    assertTrue(driver.getCurrentUrl().contains("/admin/") ,"Login was unsuccessful");

}
}
