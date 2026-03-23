package listeners;

import org.testng.*;
import utils.*;
import base.BaseTest;
import com.aventstack.extentreports.*;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();
    ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getName());
        test.set(extentTest);
    }

    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }

    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());

        String path = ScreenshotUtil.capture(BaseTest.getDriver(), result.getName());
        test.get().addScreenCaptureFromPath(path);
    }

    public void onTestSkipped(ITestResult result) {
        test.get().skip(result.getThrowable());
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }
}