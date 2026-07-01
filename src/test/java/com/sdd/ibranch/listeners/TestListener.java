package com.sdd.ibranch.listeners;

import com.sdd.ibranch.base.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

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
        BaseTest.test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        failed++;
        BaseTest.test.fail(
                result.getThrowable()
        );
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
