package AdinaPecie.testsECommerce;

import ECommerce.pageObjects.LoginPage;
import ECommerce.pageObjects.ProductEditPage;
import ECommerce.pageObjects.ProductPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static ECommerce.pageObjects.ProductPage.EMPTY_PRODUCT_LIST_CSS;
import static ECommerce.pageObjects.ProductPage.PRODUCT_LIST_CSS;
import static org.testng.Assert.assertTrue;

public class SearchTests extends BaseTest{


@BeforeClass
    public void beforeClass(){
    driver.get("https://admin-demo.nopcommerce.com");
    LoginPage loginPage = new LoginPage(driver);
    loginPage.getEmail().clear();
    loginPage.getEmail().sendKeys("admin@yourstore.com");
    loginPage.getPassword().clear();
    loginPage.getPassword().sendKeys(("admin"));
    loginPage.getForm().submit();
    }
@Test(description = "Verify that search is successful when searching for products by name")
    public void testSearchByProductName(){
        driver.get("https://admin-demo.nopcommerce.com/Admin/Product/List");
    ProductPage productPage = new ProductPage(driver);
    productPage.getProductName().sendKeys("Windows 8 Pro");
    productPage.getSearchButton().click();
    getWait(driver).until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(PRODUCT_LIST_CSS), 1));
    assertEquals(productPage.getProductList().size(), 1,
            "Search did not return the expected products!");
    assertEquals(productPage.getProductTitels().size(), productPage.getProductList().size(),
            "Product titles list has different size than product list!");
   assertEquals(productPage.getProductTitels().get(0).getText(), "Windows 8 Pro",
           "Searched product title is not correct!");
    }

    @Test(description = "Verify that after editing a product's name, it si not longer in the serch list")
    public void testEditProductName() throws InterruptedException {
        driver.get("https://admin-demo.nopcommerce.com/Admin/Product/List");
        ProductPage productPage = new ProductPage(driver);
        getWait(driver).until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(PRODUCT_LIST_CSS) , 0));
        assertNotEquals(productPage.getProductList().size(), 0,
                "No products present");
        WebElement firstProduct = productPage.getProductList().get(0);
        String firstProductTitle = productPage.getTitleFromProduct(firstProduct).getText();
        productPage.getEditButtonFromProduct(firstProduct).click();

//        edit product name
        ProductEditPage productEditPage = new ProductEditPage(driver);
        productEditPage.getProductName().clear();
       productEditPage.getProductName().sendKeys(RandomStringUtils.randomAlphanumeric(20));
        productEditPage.getSaveButton().click();

//        research the old product
        productPage.getProductName().sendKeys(firstProductTitle);
        productPage.getSearchButton().click();
        getWait(driver).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(PRODUCT_LIST_CSS)));
        assertEquals(productPage.getProductList().size(), 1,
                "Product list size after edit and search is not the expected one");

        assertTrue(isElementPresent(By.cssSelector(EMPTY_PRODUCT_LIST_CSS)),
                "Product list is not empty when searching for an invlalid product name");


    }
}
