package AdinaPecie.driver.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class OrderTests extends BaseTest{


    @Test(description = "Verify that adding elements to cart works as expected", groups = {"with_login"})
    public void testAddToCartFunctionality() {

        WebElement shoppingCart = driver.findElement(By.cssSelector("a.shopping_cart_link"));

        List<WebElement> inventoryItems = driver.findElements(By.cssSelector(".inventory_item"));
        WebElement firstItem = inventoryItems.get(0);
        String firstItemTitle = driver.findElement(By.cssSelector(".inventory_item_name")).getText();
        String firstItemPrice = driver.findElement(By.cssSelector(".inventory_item_price")).getText();
        WebElement firstItemButton = driver.findElement(By.cssSelector(".btn_inventory"));
        assertEquals(firstItemButton.getText().toLowerCase(), "add to cart",
                "Add to cart button text is incorrect before adding an item to cart");
        assertFalse(isElementPresent(By.cssSelector("fa-layers-counter.shopping_cart_badge")),
                "Shopping cart badge is present before adding elements to cart ");
        firstItemButton.click();
        assertEquals(driver.findElement(By.cssSelector(".btn_inventory")).getText().toLowerCase(), "remove",
                "Add to cart button text is incorrect after adding an item to cart");
        assertTrue(isElementPresent(By.cssSelector("span.shopping_cart_badge")),
                "Shopping cart badge is not present before adding elements to cart ");
        assertEquals(driver.findElement(By.cssSelector("span.shopping_cart_badge")).getText(), "1",
                "Number of elements on shopping card is incorrect");
        shoppingCart.click();
        assertTrue(driver.getCurrentUrl().contains("cart.html"),
                "User is not on cart page after navigating");
        List<WebElement> cartItems = driver.findElements(By.className("cart_item"));
        assertEquals(cartItems.size(),1,"Number of items in cart is incorrect");
        String cartItemName = cartItems.get(0).findElement(By.cssSelector(".inventory_item_name")).getText();
        assertEquals(cartItemName, firstItemTitle, "Wrong item added to cart");
        String cartItemPrice = cartItems.get(0).findElement(By.className("inventory_item_price")).getText();
        assertEquals(cartItemPrice, firstItemPrice,"Wrong item added to cart");

        assertTrue(isElementPresent(cartItems.get(0),By.className("cart_button")),
                "Remove button is not present");
//        WebElement continueShoppingButton = driver.findElement(By.xpath("a[class='btn_secondary']"));
//        "arguments[0].scrollIntoView(true);",continueShoppingButton;
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", continueShoppingButton);
//        assertTrue(isElementPresent(By.xpath("a[class='btn_secondary']")),
//                "Continue shopping is not present");
//        assertTrue(isElementPresent(By.xpath("a[class='btn_action checkout_button']")),
//                "Checkout button is not present");

    }

    }
