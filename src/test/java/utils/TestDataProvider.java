package utils;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
            {"standard_user", "secret_sauce"},
            {"locked_out_user", "secret_sauce"},
            {"problem_user", "secret_sauce"}
        };
    }

    @DataProvider(name = "searchData")
    public Object[][] searchData() {
        return new Object[][] {
            {"laptop"},
            {"mobile"},
            {"headphones"}
        };
    }
}