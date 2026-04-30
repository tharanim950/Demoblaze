package tests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;

public class HomeTest extends BaseTest {

	    HomePage homePage;
	    LoginPage login;
	    ProductPage product;
	    CartPage cart;

	    @BeforeMethod
	    public void setupPage() {
	    	driver.get("https://demoblaze.com");
	    	
	    	System.out.println("Driver instance: " + driver);
	    	
	        homePage = new HomePage(driver);
	        login = new LoginPage(driver);
	        product = new ProductPage(driver);
	        cart = new CartPage(driver);
	    }

//	    @Test
//	    public void verifyPhonesCategoryShowsOnlyPhones() {
//
//	        homePage.clickPhonesCategory();
//
//	        List<String> products = homePage.getDisplayedProducts();
//	        
//	        List<String> validPhones = List.of(
//	                "Samsung galaxy s6",
//	                "Nokia lumia 1520",
//	                "Nexus 6",
//	                "Samsung galaxy s7",
//	                "Iphone 6 32gb",
//	                "Sony xperia z5",
//	                "HTC One m9"
//	      
//	               
//	        );
//
//	        for (String product : products) {
//
//	        	Assert.assertTrue(
//	        		    validPhones.stream().anyMatch(p -> p.equalsIgnoreCase(product)),
//	        		    "Non-phone product displayed: " + product
//	        		);
//	        }
//	    }
	    
//	    @Test
//	    public void verifyLaptopsCategoryShowsOnlyLaptops() {
//
//	        homePage.clickLaptopsCategory();
//
//	        List<String> products = homePage.getDisplayedProducts();
//	        
//	        List<String> validLaptops = List.of(
//	        		 "Sony vaio i5",
//	        	        "Sony vaio i7",
//	        	        "MacBook air",
//	        	        "MacBook Pro",
//	        	        "2017 Dell 15.6 Inch",
//	        	        "Dell i7 8gb"
//	        );
//
//	        for (String product : products) {
//
//	        	Assert.assertTrue(
//	        			validLaptops.stream().anyMatch(p -> p.equalsIgnoreCase(product)),
//	        		    "Non-laptop product displayed: " + product
//	        		);
//	        }
//	        
//	    }
	    
//	    @Test
//	    public void verifyHomeNavigationDisplaysProducts() {
//
//	        // Navigate to another page first
//	    	 homePage.selectProduct("Samsung galaxy s6");
//
//	        // Click Home
//	        homePage.clickHome();
//
//	        List<WebElement> products = homePage.getProducts();
//
//	        Assert.assertTrue(
//	                products.size() > 0,
//	                "Home page did not display products"
//	        );
//	    }

//	    @Test
//	    public void verifyNavbarNavigationLinks() {
//
//	        // Home
//	        homePage.clickHome();
//	        Assert.assertTrue(homePage.areProductsDisplayed(),
//	                "Home page products not displayed");
//
//	        // Cart
//	        homePage.clickCart();
//	        Assert.assertTrue(homePage.isCartPageDisplayed(),
//	                "Cart page not displayed");
//
//	        // Contact
//	        homePage.clickContact();
//	        Assert.assertTrue(homePage.isContactModalDisplayed(),
//	                "Contact modal not displayed");
//	    }
	    
//	    @Test
//	    public void verifyUserCanLogout() {
//	    	
//	        login.clickLoginLink();
//
//	        login.waitForLoginModal();
//
//	        login.enterUsername("heedo");
//	        login.enterPassword("test@123");
//
//	        login.clickLoginButton();
//
//	      
//	        homePage.clickLogout();
//
//	        Assert.assertTrue(
//	                homePage.isLoginButtonVisible(),
//	                "Login button not visible after logout"
//	        );
//
//	        Assert.assertTrue(
//	                homePage.areProductsDisplayed(),
//	                "Home page not displayed after logout"
//	        );
//	    }
	
//	    @Test
//	    public void verifyProductGridLayout() {
//
//	        List<WebElement> cards = homePage.getProductCards();
//
//	        Assert.assertTrue(cards.size() >= 6, "Not enough products to form grid");
//
//	        int firstRowY = cards.get(0).getLocation().getY();
//	        int secondRowY = cards.get(3).getLocation().getY();
//
//	        Assert.assertTrue(secondRowY > firstRowY,
//	                "Products are not displayed in grid rows");
//	    }
	    
//	    @Test
//	    public void verifyImportantButtonsVisibleAndClickable() {
//
//	        Assert.assertTrue(homePage.isSignupVisible(), "Sign Up button not visible");
//	        Assert.assertTrue(homePage.isSignupClickable(), "Sign Up button not clickable");
//
//	        Assert.assertTrue(homePage.isLoginButtonVisible(), "Login button not visible");
//	        Assert.assertTrue(homePage.isLoginClickable(), "Login button not clickable");
//
//	        homePage.selectProduct("Samsung galaxy s6");
//
//	        Assert.assertTrue(product.isAddToCartClickable(),
//	                "Add to Cart button not visible or clickable");
//	    }
	    
//	    @Test
//	    public void verifyFontConsistencyAcrossPagesNav() {
//
//	    	String homeFont = homePage.getNavbarFontSize();
//
//	        homePage.selectProduct("Samsung galaxy s6");
//
//	        String productFont = product.getNavbarFontSize();
//
//	        product.clickCart();
//
//	        String cartFont = cart.getNavbarFontSize();
//
//	        Assert.assertEquals(productFont, homeFont);
//	        Assert.assertEquals(cartFont, homeFont);
//	    }
	    
//	    @Test
//	    public void verifyFontConsistencyAcrossPages() {
//
//	        // Get font from Home page
//	        String homeFontFamily = homePage.getFontFamily();
//
//	        // Open product page
//	        homePage.selectProduct("Samsung galaxy s6");
//
//	        // Get font from Product page
//	        String productFontFamily = product.getFontFamily();
//
//	        // Go to Cart page
//	        product.clickCart();
//
//	        // Get font from Cart page
//	        String cartFontFamily = cart.getFontFamily();
//
//	        // Assertions
//	        Assert.assertEquals(productFontFamily, homeFontFamily,
//	                "Font family inconsistent between Home and Product page");
//
//	        Assert.assertEquals(cartFontFamily, homeFontFamily,
//	                "Font family inconsistent between Home and Cart page");
//	    }
	    
//	    @Test
//	    public void verifyAddToCartAlertIsReadable() {
//
//	        // Click first product
//	    	homePage.selectProduct("Samsung galaxy s6");
//
//	        // Click Add to cart
//	        product.clickAddToCart();
//
//	        // Wait for alert
//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//
//	        String alertText = alert.getText();
//
//	        // Verify alert text is readable
//	        Assert.assertTrue(alertText.length() > 0, "Alert message is empty");
//
//	        // Verify expected message
//	        Assert.assertTrue(alertText.contains("Product added"),
//	                "Unexpected alert message: " + alertText);
//
//	        // Accept alert
//	        alert.accept();
//	    }
	    
//	    @Test
//	    public void verifyPurchaseConfirmationPopupReadable() throws InterruptedException {
//
//	    	homePage.selectProduct("Samsung galaxy s6");
//	        product.clickAddToCart();
//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	        wait.until(ExpectedConditions.alertIsPresent()).accept();
//
//	        product.clickCart();
//
//	        cart.clickPlaceOrder();
//
//	        cart.fillOrderDetails("John", "USA", "New York",
//	                "123456789", "12", "2026");
//	        
//	        Thread.sleep(5000);
//
//	        cart.clickPurchase();
//	        Thread.sleep(7000);
//
//	        // Wait for confirmation popup
//	        String confirmationText = cart.getConfirmationMessage();
//
//	        Assert.assertTrue(confirmationText.contains("Thank you"),
//	                "Confirmation popup message not readable");
//	        
//	        String orderDetails = cart.getOrderDetails();
//
//	        Assert.assertTrue(orderDetails.contains("Id"), "Order ID not present");
//	        Assert.assertTrue(orderDetails.contains("Amount"), "Order Amount not present");
//	    }
	    
//	    @Test
//	    public void verifyNoHorizontalScrollOnMobileView() {
//
//	        // Simulate mobile screen size
//	        driver.manage().window().setSize(new Dimension(375, 812));
//
//	        driver.get("https://demoblaze.com/");
//
//	        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//	        Long viewportWidth = (Long) js.executeScript("return window.innerWidth;");
//	        Long pageWidth = (Long) js.executeScript("return document.body.scrollWidth;");
//
//	        System.out.println("Viewport width: " + viewportWidth);
//	        System.out.println("Page width: " + pageWidth);
//
//	        Assert.assertTrue(pageWidth <= viewportWidth,
//	                "Page requires horizontal scrolling on mobile screen");
//	    }
}
