package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.CartPage;

public class CartTest extends BaseTest {
	
    HomePage home;
    ProductPage product;
    CartPage cart;
    LoginPage login;

    @BeforeMethod
    public void setupPages() {

        driver.get("https://demoblaze.com");

        home = new HomePage(driver);
        login = new LoginPage(driver);
        product = new ProductPage(driver);
        cart = new CartPage(driver);

        home.clickLoginLink();
        login.waitForLoginModal();

        login.enterUsername("heedo"); 
        login.enterPassword("test@123");
        login.clickLoginButton();
        login.waitForWelcomeMessage();
        
    }

//    @Test
//    public void verifyCartDisplaysMultipleAddedProducts() {
//
//        // Add first product
//        home.selectProduct("Samsung galaxy s6");
//        product.clickAddToCart();
//        product.getAddToCartAlertText();
//
 //       home.goToHome();
//
//        // Add second product
//        home.selectProduct1("Nokia lumia 1520");
//        product.clickAddToCart();
//        product.getAddToCartAlertText();
//
//        // Go to cart
//        cart.openCart();
//
//    boolean titlePresent = cart.isProductTitleDisplayed("Samsung galaxy s6");
//    boolean pricePresent = cart.isProductPriceDisplayed("360");
//
//    Assert.assertTrue(titlePresent, "Samsung galaxy s6 not displayed in cart");
//    Assert.assertTrue(pricePresent, "Price not displayed in cart");
//    
//    boolean titlePresent1 = cart.isProductTitleDisplayed("Nokia lumia 1520");
//    boolean pricePresent1 = cart.isProductPriceDisplayed("820");
//
//    Assert.assertTrue(titlePresent, "Samsung galaxy s6 not displayed in cart");
//    Assert.assertTrue(pricePresent, "Price not displayed in cart");
//    
//    
//}
    
//    @Test
//    public void verifyProductDeletionUpdatesCartTotal() {
//
//        // Add product
//        home.selectProduct("Samsung galaxy s6");
//
//        product.clickAddToCart();
//        product.getAddToCartAlertText();
//
//        // Open cart
//        cart.openCart();
//
//        // Capture initial values
//        int totalBeforeDelete = cart.getTotalPrice();
//        int initialCount = cart.getCartItemCount();
//
//        // Get the row of the product
//        WebElement row = cart.getRow("Samsung galaxy s6");
//
//        // Click delete inside that row
//        row.findElement(By.xpath(".//a[text()='Delete']")).click();
//
//        // Wait until row becomes stale (removed from DOM)
 //       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.stalenessOf(row));
//
//        // Wait until row count updates
//        cart.waitForCartUpdate(initialCount);
//
//        // Capture values after deletion
//        int finalCount = cart.getCartItemCount();
//        int totalAfterDelete = cart.getTotalPrice();
//
//        // Assertion 1: Row count reduced
//        Assert.assertEquals(finalCount, initialCount - 1,
//                "Cart row count did not decrease after deletion");
//
//        
//        Assert.assertEquals(totalAfterDelete, 0,
//                "Cart total was not updated correctly after deletion");
//        
//        Assert.assertEquals(driver.findElements(
//                By.xpath("//td[contains(text(),'Samsung galaxy s6')]")
//        ).size(), 0);
//    }
    
//    @Test
//    public void verifyUserCanAddMultipleProductsToCart() {
//
//        // Add first product
//        home.selectProduct("Samsung galaxy s6");
//        int price1 = product.getProductPrice();
//        product.clickAddToCart();
//        product.getAddToCartAlertText();
//
//        home.goToHome();
//
//        // Add second product
//        home.selectProduct1("Nokia lumia 1520");
//        int price2 = product.getProductPrice();
//        product.clickAddToCart();
//        product.getAddToCartAlertText();
//        
//        home.goToHome();
//
//        // Add second product
//        
//        home.selectProduct1("Samsung galaxy s7");
//        int price3 = product.getProductPrice();
//        product.clickAddToCart();
//        product.getAddToCartAlertText();
//
//        // Open cart
//        cart.openCart();
//        
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr")));
//        
//        List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
//
//        System.out.println("Cart items: " + rows.size());
//
//        Assert.assertEquals(rows.size(), 3, "Cart does not contain 3 products");
//
//
//        // Verify total price
//        int expectedTotal = price1 + price2 + price3;
//        int actualTotal = cart.getTotalPrice();
//
//        Assert.assertEquals(actualTotal, expectedTotal,
//                "Cart total price is incorrect");
//    }
    
//    @Test
//    public void verifyUserCanPlaceOrderSuccessfully() {
//    	
//    	cart.openCart();        
//    	
//    	cart.clickPlaceOrder();
//
//        cart.fillOrderDetails(
//                "John",
//                "USA",
//                "New York",
//                "123456789",
//                "June",
//                "2026"
//        );
//
//        cart.clickPurchase();
//
//        String confirmation = cart.getConfirmationMessage();
//
//        Assert.assertEquals(
//                confirmation,
//                "Thank you for your purchase!",
//                "Purchase confirmation message not displayed"
//        );
//
//        String orderDetails = cart.getOrderDetails();
//
//        Assert.assertTrue(orderDetails.contains("Id"), "Order ID not present");
//        Assert.assertTrue(orderDetails.contains("Amount"), "Order Amount not present");
//    }
//    
//    @Test
//    public void verifyPlaceOrderWithEmptyFields() {
//    	
//    	cart.openCart();
//
//        cart.clickPlaceOrder();
//
//        cart.clickPurchase();
//
//        String alertMsg = cart.getAlertMessage();
//
//        Assert.assertTrue(
//                alertMsg.contains("Please fill out"),
//                "Required field alert not displayed"
//        );
//    }
    
//    @Test
//    public void verifyOrderConfirmationPopup() {
//    	
//    	cart.openCart();        
//    	
//    	cart.clickPlaceOrder();
//
//        cart.fillOrderDetails(
//                "John",
//                "USA",
//                "New York",
//                "123456789",
//                "June",
//                "2026"
//        );
//
//        cart.clickPurchase();
//
//        String confirmation = cart.getConfirmationMessage();
//
//        Assert.assertEquals(
//                confirmation,
//                "Thank you for your purchase!",
//                "Purchase confirmation message not displayed"
//        );
//
//        String orderDetails = cart.getOrderDetails();
//
//        Assert.assertTrue(orderDetails.contains("Id"), "Order ID not present");
//        Assert.assertTrue(orderDetails.contains("Amount"), "Order Amount not present");
//    }
    
    
}