package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.AmazonPage;
import retry.RetryAnalyzer;

public class AmazonTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testAmazonFlow() {

        AmazonPage page = new AmazonPage(getDriver());

        page.searchProduct("HP Smart Tank");
        Assert.assertTrue(page.isSearchResultDisplayed());

        page.selectProduct();
        page.switchtoNewTab();
        Assert.assertTrue(page.isProductPageOpened());

        page.selectQuantity();
        page.addToCart();
        page.goToCart();

        Assert.assertTrue(page.isCartPageOpened());
    }
}