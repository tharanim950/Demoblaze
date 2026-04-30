package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;

public class ProductTest extends BaseTest {

    HomePage home;
    ProductPage product;
    LoginPage login;

    @BeforeMethod
    public void setupPages() {

        driver.get("https://demoblaze.com");

        home = new HomePage(driver);
        login = new LoginPage(driver);
        product = new ProductPage(driver);

        home.clickLoginLink();
        login.waitForLoginModal();

        login.enterUsername("heedo");
        login.enterPassword("test@123");
        login.clickLoginButton();
        login.waitForWelcomeMessage();
        
    }

//    @Test
//    public void verifyProductAddedToCartAlert() {
//
//        home.selectProduct("Samsung galaxy s6");
//        product.clickAddToCart();
//
//        String alertText = product.getAddToCartAlertText();
//
//        System.out.println("Alert message: " + alertText);
//
//        Assert.assertTrue(alertText.contains("Product added"),
//                "Unexpected alert message: " + alertText);
//    }
    
//    @Test
//    public void verifyProductDetailsPageOpens() {
//
//    	home.selectProduct("Samsung galaxy s6");
//
//        Assert.assertTrue(
//                product.isProductImageDisplayed(),
//                "Product image not displayed"
//        );
//
//        Assert.assertTrue(
//                product.isDescriptionDisplayed(),
//                "Product description not displayed"
//        );
//
//        Assert.assertTrue(
//                product.isPriceDisplayed(),
//                "Product price not displayed"
//        );
//    }
}
