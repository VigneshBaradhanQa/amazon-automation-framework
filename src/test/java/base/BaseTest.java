package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser) {

    	if (browser.equalsIgnoreCase("chrome")) {
    	    WebDriverManager.chromedriver().setup();
    	    driver.set(new ChromeDriver());
    	} 
    	else if (browser.equalsIgnoreCase("firefox")) {
    	    WebDriverManager.firefoxdriver().setup();
    	    driver.set(new FirefoxDriver());
    	} 
    	else {
    	    throw new IllegalArgumentException("Browser not supported: " + browser);
    	}

        getDriver().manage().window().maximize();

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        getDriver().get(ConfigReader.get("url"));
    }

    @AfterMethod
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}