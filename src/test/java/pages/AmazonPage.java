package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AmazonPage extends BasePage {

    public AmazonPage(WebDriver driver) {
        super(driver);
    }
    By searchBox = By.id("twotabsearchtextbox");
    By searchButton = By.id("nav-search-submit-button");
    By firstProduct = By.xpath("//div[@data-component-type='s-search-result']");
    By productTitle = By.id("productTitle");
    By quantityDropdown = By.xpath("//span[contains(@id,'a-autoid') and contains(@class,'dropdown')]");
    By quantityOption2 = By.xpath("//li[@aria-labelledby='quantity_1']");
    By addToCart = By.id("add-to-cart-button");
    By cartButton = By.id("nav-cart");
    By goToCartPopup = By.xpath("//a[contains(@href,'/cart')]");
    By cartPageTitle = By.id("sc-active-cart");
    By cartItemName = By.xpath("//span[@class='a-truncate-cut']");
    By cartQuantity = By.xpath("//span[@data-a-selector='value']");
    By cartSubtotal = By.id("sc-subtotal-amount-activecart");

    public void searchProduct(String productName) {
        type(searchBox, productName);
        click(searchButton);
    }
    public boolean isSearchResultDisplayed() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(firstProduct));
            return driver.findElements(firstProduct).size() > 0;
        } catch (Exception e) {
            return false;
        }}
    public void selectProduct() {
        driver.findElements(firstProduct).get(0).click();
    }
    public void switchtoNewTab() {
        String parent = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(parent)) {
                driver.switchTo().window(handle);
                break;
            }}}
    public boolean isProductPageOpened() {
        return isDisplayed(productTitle);
    }
    public boolean selectQuantity() {
        try {
            if (driver.findElements(quantityDropdown).size() > 0) {
                wait.until(ExpectedConditions.elementToBeClickable(quantityDropdown)).click();
                wait.until(ExpectedConditions.elementToBeClickable(quantityOption2)).click();
                return true;
            }}
         catch (Exception e) {
            System.out.println("Quantity dropdown not available");
        }
        return false;
    }
    public void addToCart() {
        click(addToCart);
    }
    public void goToCart() {
        try {
            if (driver.findElements(goToCartPopup).size()>0) {
                click(goToCartPopup);
            } else {
                click(cartButton);
            }}
        catch (Exception e) {
            click(cartButton);
        } }
    public boolean isCartPageOpened() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(cartPageTitle)).isDisplayed();
        } catch (Exception e) {
            return false;
        }}
    public String getCartItemName() {
        return getText(cartItemName);
    }
    public String getCartQuantity() {
        return getText(cartQuantity);
    }
    public String getCartSubtotal() {
        return getText(cartSubtotal);
    } }