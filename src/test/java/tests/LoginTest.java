package tests;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	    LoginPage login;

	    @BeforeMethod
	    public void setupPage() {
	        login = new LoginPage(driver);
	    }

//	    @Test
//	    public void verifyLoginWithValidCredentials() {
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
//	        String welcomeText = login.getWelcomeMessage();
//
//	        Assert.assertTrue(welcomeText.contains("Welcome"),
//	                "Login failed. Message: " + welcomeText);
//	    }
	    
//	    @Test
//	    public void verifyLoginWithWrongPassword() {
//
//	        login.clickLoginLink();
//
//	        login.waitForLoginModal();
//
//	        login.enterUsername("heedo");     // valid username
//	        login.enterPassword("wrong123");  // wrong password
//
//	        login.clickLoginButton();
//
//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//	        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//
//	        String alertText = alert.getText();
//
//	        System.out.println("Alert message: " + alertText);
//
//	        Assert.assertTrue(alertText.contains("Wrong password"),
//	                "Unexpected alert message: " + alertText);
//
//	        alert.accept();
//	    }
	    
//	    @Test
//	    public void verifyLoginWithEmptyFields() {
//
//	        login.clickLoginLink();
//
//	        login.waitForLoginModal();
//
//	        // Do NOT enter username or password
//
//	        login.clickLoginButton();
//
//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//	        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//
//	        String alertText = alert.getText();
//
//	        System.out.println("Alert message: " + alertText);
//
//	        Assert.assertTrue(alertText.contains("Please fill out"),
//	                "Unexpected alert message: " + alertText);
//
//	        alert.accept();
//	    }
	    
//	    @Test
//	    public void verifyUsernameFormatValidation() {
//
//	        throw new SkipException("Email format validation not implemented in application");
//
//	    }
	    
//	    @Test
//	    public void verifyPasswordFieldMasksInput() {
//
//	        login.clickLoginLink();
//
//	        login.waitForLoginModal();
//
//	        String fieldType = login.getPasswordFieldType();
//
//	        System.out.println("Password field type: " + fieldType);
//
//	        Assert.assertEquals(fieldType, "password",
//	                "Password field is not masked.");
//	    }
	

}
