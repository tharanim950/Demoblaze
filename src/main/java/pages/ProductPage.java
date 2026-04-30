package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    WebDriver driver;
    WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Locators

    @FindBy(linkText = "Add to cart")
    WebElement addToCartButton;

    @FindBy(className = "name")
    WebElement productName;

//    @FindBy(className = "price-container")
//    WebElement productPrice;
    
    By productImage = By.xpath("//div[@class='item active']//img");
    By productDescription = By.id("more-information");
    By productPrice = By.xpath("//h3[@class='price-container']");
    By productTitle = By.xpath("//h2[@class='name']");
    By cartLink = By.id("cartur");
    By navbar = By.id("nava");
    By body = By.tagName("body");
    
    
    
    
    public String getNavbarFontSize() {
        return driver.findElement(navbar).getCssValue("font-size");
    }

    // Actions

    public String getProductName() {
        return productName.getText();
    }

    public int getProductPrice() {
        String priceText = driver.findElement(By.className("price-container")).getText();
        return Integer.parseInt(priceText.replaceAll("[^0-9]", ""));
    }

    public void clickAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    public String getAddToCartAlertText() {

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String alertText = alert.getText();

        alert.accept();

        return alertText;
    }
    
    public void selectProduct(String productName) {

        By product = By.xpath("//div[@class='card-block']//a[contains(text(),'" + productName + "')]");

        driver.findElement(product).click();
    }
    
    public void acceptAlert() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();
    }
    
    public boolean isProductImageDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(productImage)
        ).isDisplayed();
    }
    
    public boolean isDescriptionDisplayed() {

        return driver.findElement(productDescription).isDisplayed();
    }
    
    public boolean isPriceDisplayed() {

        return driver.findElement(productPrice).isDisplayed();
    } 
    
    
    public boolean isAddToCartClickable() {

        return wait.until(
                ExpectedConditions.elementToBeClickable(addToCartButton)
        ).isDisplayed();
    }
    
    public String getFontFamily() {

        return driver.findElement(productTitle).getCssValue("font-family");
    }
    
    public String getFontSize() {

        return driver.findElement(productTitle).getCssValue("font-size");
    }
    public void clickCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
    }
    
}
