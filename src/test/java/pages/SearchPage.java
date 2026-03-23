package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    private By searchBox = By.id("twotabsearchtextbox");
    private By searchBtn = By.id("nav-search-submit-button");
    private By firstResult = By.xpath("//div[@data-component-type='s-search-result']");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchProduct(String product) {
        type(searchBox, product);
        click(searchBtn);
    }

    public boolean isSearchResultDisplayed() {
        return isDisplayed(firstResult);
    }
}