package listeners;

import org.testng.*;
import utils.*;
import base.BaseTest;
import com.aventstack.extentreports.*;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test;

    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());

        String path = ScreenshotUtil.capture(BaseTest.getDriver(), result.getName());
        test.addScreenCaptureFromPath(path);
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }
}