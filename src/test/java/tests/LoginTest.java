package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {

        LoginPage loginPage = new LoginPage(getDriver());

        String email = ConfigReader.get("email");
        String password = ConfigReader.get("password");

        loginPage.login(email, password);
    }
}