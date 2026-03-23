package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By signInBtn = By.id("nav-link-accountList");
    private By email = By.id("ap_email");
    private By continueBtn = By.id("continue");
    private By password = By.id("ap_password");
    private By loginBtn = By.id("signInSubmit");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickSignIn() {
        click(signInBtn);
    }

    public void enterEmail(String mail) {
        type(email, mail);
    }

    public void clickContinue() {
        click(continueBtn);
    }

    public void enterPassword(String pwd) {
        type(password, pwd);
    }

    public void clickLogin() {
        click(loginBtn);
    }

    public void login(String mail, String pwd) {
        clickSignIn();
        enterEmail(mail);
        clickContinue();
        enterPassword(pwd);
        clickLogin();
    }
}