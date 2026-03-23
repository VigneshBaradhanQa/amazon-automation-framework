package utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtil {

    public static String capture(WebDriver driver, String testName) {

        String path = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(path);
            FileHandler.copy(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path; 
    }
}