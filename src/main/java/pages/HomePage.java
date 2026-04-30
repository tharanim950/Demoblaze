package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;
    
    

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        
        
    }
    
    @FindBy(id = "login2")
    WebElement loginLink;
    
    By logoutBtn = By.id("logout2");
    By loginBtn = By.id("login2");
    By signupBtn = By.id("signin2");
    By addToCartBtn = By.xpath("//a[text()='Add to cart']");
    
    By phonesCategory = By.linkText("Phones");
   // By phonesCategory = By.xpath("//a[text()='Phones']");
    By laptopsCategory = By.linkText("Laptops");
    By monitorsCategory = By.linkText("Monitors");

    By productTitles = By.xpath("//h4[@class='card-title']/a");
    By cartLink = By.id("cartur");
    By contactLink = By.linkText("Contact");
    By cartTitle = By.xpath("//h2[text()='Products']");
    By contactModal = By.id("exampleModal");
    By confirmationMsg = By.xpath("//h2[text()='Thank you for your purchase!']");
    
    By productCards = By.xpath("//div[@class='card h-100']");
    By navbar = By.id("nava");
    By body = By.tagName("body");
    
    
    
    public String getFontFamily() {
        return driver.findElement(body).getCssValue("font-family");
    }
    
    public String getNavbarFontSize() {
        return driver.findElement(navbar).getCssValue("font-size");
    }

  //  @FindBy(linkText = "Samsung galaxy s6")
  //  WebElement productLink;
    
    public void clickLoginLink() {
        loginLink.click();
    }

    public void selectProduct(String productName) {

        By product = By.xpath("//div[@class='card-block']//a[contains(text(),'" + productName + "')]");

        driver.findElement(product).click();
    }
    
    public void selectProduct1(String productName) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By product = By.xpath("//a[text()='" + productName + "']");

        wait.until(ExpectedConditions.elementToBeClickable(product)).click();
    }
    
    @FindBy(id = "nava")
    WebElement homeButton;
    
  //  By homeNav = By.linkText("Home");
    By homeNav = By.xpath("//a[contains(text(),'Home')]");

    public void goToHome() {
        homeButton.click();
    }
    
    public void clickPhonesCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(phonesCategory)).click();
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(productTitles, 0));
    }

    public void clickLaptopsCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(laptopsCategory)).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                productTitles, "Sony vaio i5"));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(productTitles, 0));
    }

    public void clickMonitorsCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(monitorsCategory)).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                productTitles, "Apple monitor"));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(productTitles, 0));
    }
    
    public List<String> getDisplayedProducts() {

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(productTitles, 0));

        List<WebElement> products = driver.findElements(productTitles);

        List<String> names = new ArrayList<>();

        for (WebElement product : products) {
            names.add(product.getText());
        }

        return names;
    }
    
    public void clickHome() {

        wait.until(ExpectedConditions.elementToBeClickable(homeNav)).click();
    }
    
    public List<WebElement> getProducts() {

        return wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(productTitles)
        );
    }
    
    public void clickCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
    }
    
    public void clickContact() {
        wait.until(ExpectedConditions.elementToBeClickable(contactLink)).click();
    }
    
    public boolean areProductsDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(productTitles)
        ).size() > 0;
    }
    
    public boolean isCartPageDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(cartTitle)
        ).isDisplayed();
    }
    
    public boolean isContactModalDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(contactModal)
        ).isDisplayed();
    }
    
    public void clickLogout() {

        wait.until(ExpectedConditions.elementToBeClickable(logoutBtn)).click();
    }
    
    public boolean isLoginButtonVisible() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(loginBtn)
        ).isDisplayed();
    }
    
    
    public List<WebElement> getProductCards() {

        return wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(productCards)
        );
    }
    
    public boolean isSignupVisible() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(signupBtn)
        ).isDisplayed();
    }
    
    public boolean isSignupClickable() {

        return wait.until(
                ExpectedConditions.elementToBeClickable(signupBtn)
        ).isEnabled();
    }
    
    public boolean isLoginClickable() {

        return wait.until(
                ExpectedConditions.elementToBeClickable(loginBtn)
        ).isEnabled();
    }
    
    public boolean isAddToCartClickable() {

        return wait.until(
                ExpectedConditions.elementToBeClickable(addToCartBtn)
        ).isDisplayed();
    }
    
   
    
    public String getFontSize() {

        return driver.findElement(productTitles).getCssValue("font-size");
    }
    
    public String getConfirmationMessage() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(confirmationMsg)
        ).getText();
    }
    
 
}
