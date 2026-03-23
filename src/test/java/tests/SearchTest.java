package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.SearchPage;

public class SearchTest extends BaseTest {

    @Test
    public void searchProductTest() {

        SearchPage searchPage = new SearchPage(getDriver());

        searchPage.searchProduct("iPhone");

        Assert.assertTrue(searchPage.isSearchResultDisplayed(), "Search results are not displayed");
    }
}