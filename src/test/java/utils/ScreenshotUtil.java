package utils;

import org.openqa.selenium.*;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    public static String capture(WebDriver driver, String testName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = "reports/" + testName + ".png";
            FileUtils.copyFile(src, new File(path));
            return path;
        } catch (Exception e) {
            return null;
        }
    }
}