package tests;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

import pages.SignupPage;
import utilities.ScreenshotUtil;

public class SignupTest extends BaseTest {
	
	SignupPage signup;
	@BeforeMethod
	public void setUp() {

	    WebDriverManager.chromedriver().setup();

	    driver = new ChromeDriver();

	    driver.manage().window().maximize();
	    driver.get("https://demoblaze.com");
	    
	    signup = new SignupPage(driver);
	    signup.clickSignupLink();
	}

//    @Test
//    public void verifySignup() {
//
//        SignupPage signup = new SignupPage(driver);
//        
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        signup.clickSignupLink();
//        
//        signup.waitForSignupModal();
//        
//        signup.enterUsername("heedo");
//        signup.enterPassword("test@123");
//        signup.clickSignupButton();
//        
//        Alert alert = signup.waitForAlert();
//        String alertText = alert.getText();
//
//        System.out.println("Alert message: " + alertText);
//
//        alert.accept();
//
//        // Take screenshot AFTER alert is closed
//        ScreenshotUtil.captureScreenshot(driver, "SignupSuccess");
//        
//        Assert.assertTrue(alertText.contains("Sign up successful"),
//                "Unexpected alert message: " + alertText);
//
//    }
    
//    @Test
//    public void verifyUserAlreadyExistsAlert() {
//
//    	 signup.enterUsername("heedo");
//         signup.enterPassword("test@123");
//        signup.clickSignupButton();
//
//        Alert alert = signup.waitForAlert();
//        String alertText = alert.getText();
//
//        System.out.println("Alert message: " + alertText);
//
//        Assert.assertTrue(alertText.contains("already exist"),
//                "Expected 'user already exists' alert but got: " + alertText);
//
//        alert.accept();
//    }
    
//    @Test
//    public void verifySignupWithEmptyFields() {
//
//        SignupPage signup = new SignupPage(driver);
//
//        
//
//       // signup.clickSignupLink();
//
//        signup.waitForSignupModal();
//
//        // Do NOT enter username and password
//
//        signup.clickSignupButton();
//        
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//
//        String alertText = alert.getText();
//
//        System.out.println("Alert message: " + alertText);
//
//        Assert.assertTrue(alertText.contains("Please fill out"),
//                "Unexpected alert message: " + alertText);
//
//        alert.accept();
//    }

}
