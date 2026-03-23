package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import utils.ConfigReader;

public class BaseTest {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());

        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        getDriver().get(ConfigReader.get("url"));
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }
}