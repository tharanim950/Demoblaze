package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    By cartLink = By.id("cartur");
    By cartTable = By.id("tbodyid");
    By cartRows = By.xpath("//tbody/tr");
    By totalPrice = By.id("totalp");
    By deleteButton = By.linkText("Delete");
    
    By placeOrderBtn = By.xpath("//button[text()='Place Order']");
    By nameField = By.id("name");
    By countryField = By.id("country");
    By cityField = By.id("city");
    By cardField = By.id("card");
    By monthField = By.id("month");
    By yearField = By.id("year");
    By purchaseBtn = By.xpath("//button[text()='Purchase']");
    By cartHeader = By.xpath("//h2[text()='Products']");

    By confirmationMsg = By.xpath("//h2[text()='Thank you for your purchase!']");
    By orderDetails = By.xpath("//p[contains(@class,'lead')]");
    By okBtn = By.xpath("//button[text()='OK']");  
    By navbar = By.id("nava");
    By body = By.tagName("body");
    
    
    
    public String getFontFamily() {
        return driver.findElement(body).getCssValue("font-family");
    }
    
    public String getNavbarFontSize() {
        return driver.findElement(navbar).getCssValue("font-size");
    }
    		
    		public void openCart() {
        driver.findElement(cartLink).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartTable));
    }

    public boolean isProductTitleDisplayed(String productName) {
        return driver.findElements(By.xpath("//td[text()='" + productName + "']")).size() > 0;
    }

    public boolean isProductPriceDisplayed(String price) {
        return driver.findElements(By.xpath("//td[text()='" + price + "']")).size() > 0;
    }
    

    // Get total price
    public int getTotalPrice() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement total = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("totalp"))
        );

        wait.until(driver -> {
            String text = total.getText();
            return text.isEmpty() || text.matches("\\d+");
        });

        String totalText = total.getText();

        if (totalText.isEmpty()) {
            return 0;
        }

        return Integer.parseInt(totalText);
    }
    
    // Get number of products in cart
    public int getCartItemCount() {
        return driver.findElements(cartRows).size();
    }

    // Delete product
    public void deleteProduct() {
        driver.findElement(deleteButton).click();
    }

    public void waitForCartUpdate(int initialCount) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.numberOfElementsToBe(
                By.xpath("//tbody/tr"), initialCount - 1
        ));
    }
    
    public WebElement getRow(String productName) {

        return driver.findElement(
                By.xpath("//td[normalize-space()='" + productName + "']/parent::tr")
        );
    }
    
    public void clickPlaceOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
    }
    
    public void fillOrderDetails(String name, String country, String city,
            String card, String month, String year) {

driver.findElement(nameField).sendKeys(name);
driver.findElement(countryField).sendKeys(country);
driver.findElement(cityField).sendKeys(city);
driver.findElement(cardField).sendKeys(card);
driver.findElement(monthField).sendKeys(month);
driver.findElement(yearField).sendKeys(year);
}
    
    public void clickPurchase() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement purchaseBtn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//button[text()='Purchase']")));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", purchaseBtn);

        purchaseBtn.click();
    }
    
    public String getConfirmationMessage() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(confirmationMsg)
        ).getText();
    }
    
    public String getOrderDetails() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement orderDetails = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                		By.xpath("//p[contains(@class,'lead')]")));

        return orderDetails.getText();
    }
    
    public String getAlertMessage() {

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        String message = alert.getText();

        alert.accept();

        return message;
    }
    
    public String getCartFont() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(cartHeader)
        ).getCssValue("font-family");
    }
    
    public String getCartFontSize() {

        return driver.findElement(cartHeader).getCssValue("font-size");
    }
    
    
    
    
}
