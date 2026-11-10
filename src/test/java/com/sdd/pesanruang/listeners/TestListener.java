package com.sdd.pesanruang.listeners;

import com.sdd.pesanruang.base.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.sdd.pesanruang.utils.ScreenshotUtil;


public class TestListener implements ITestListener {

    public static int total = 0;
    public static int passed = 0;
    public static int failed = 0;
    public static int skipped = 0;

    @Override
    public void onTestStart(ITestResult result) {
        total++;

        BaseTest.test =
                BaseTest.extent.createTest(
                        result.getMethod().getDescription()
                );
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        passed++;

        BaseTest baseTest = (BaseTest) result.getInstance();

        String screenshot =
                ScreenshotUtil.takeScreenshot(
                        baseTest.getDriver(),
                        result.getMethod().getMethodName());

        BaseTest.test
                .pass("Test Passed")
                .addScreenCaptureFromPath(screenshot);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        failed++;

        BaseTest baseTest = (BaseTest) result.getInstance();

        String screenshot =
                ScreenshotUtil.takeScreenshot(
                        baseTest.getDriver(),
                        result.getMethod().getMethodName());

        BaseTest.test
                .fail(result.getThrowable())
                .addScreenCaptureFromPath(screenshot);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        skipped++;
        BaseTest.test.skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        BaseTest.extent.flush();
    }

}
