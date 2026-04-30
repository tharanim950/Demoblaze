package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class SignupPage extends BasePage {

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    // Sign up link in navbar
    @FindBy(id = "signin2")
    WebElement signUpLink;

    // Username field
    @FindBy(id = "sign-username")
    WebElement username;

    // Password field
    @FindBy(id = "sign-password")
    WebElement password;

    // Sign up button inside modal
    @FindBy(xpath = "//button[text()='Sign up']")
    WebElement signupButton;

    // Close button
    @FindBy(xpath = "//div[@id='signInModal']//button[text()='Close']")
    WebElement closeButton;

    // ---------- Actions ----------

    public void clickSignupLink() {
        signUpLink.click();
    }

    public void enterUsername(String user) {
        username.clear();
        username.sendKeys(user);
    }

    public void enterPassword(String pass) {
        password.clear();
        password.sendKeys(pass);
    }

    public void clickSignupButton() {
        signupButton.click();
    }

    public void clickCloseButton() {
        closeButton.click();
    }
    
    public void waitForSignupModal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(username));
    }
    
    public Alert waitForAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.alertIsPresent());
    }

}
