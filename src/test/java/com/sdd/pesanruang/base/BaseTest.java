package com.sdd.ibranch.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.sdd.ibranch.listeners.TestListener;
import com.sdd.ibranch.utils.ConfigReader;
import com.sdd.ibranch.utils.ExtentManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class BaseTest {
    protected WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    // Tambahan untuk Extent Report
    public static ExtentReports extent;
    public static ExtentTest test;

    @AfterSuite
    public void generateSummary() {
        double passRate = ((double) TestListener.passed / TestListener.total) * 100;
        double failRate = ((double) TestListener.failed / TestListener.total) * 100;
        double skipRate = ((double) TestListener.skipped / TestListener.total) * 100;

        ExtentTest summary = extent.createTest("Execution Summary");
//        summary.info("Total Test Case : " + TestListener.total);
//        summary.pass("Passed : " + TestListener.passed);
//        summary.info("Failed : " + TestListener.failed);
//        summary.skip("Skipped : " + TestListener.skipped);

        summary.info(String.format("Pass Rate : %.2f%%", passRate));
        summary.info(String.format("Fail Rate : %.2f%%", failRate));
        summary.info(String.format("Skip Rate : %.2f%%", skipRate));

        if (TestListener.failed == 0) {
            summary.pass("Execution Result : PASSED");
        } else {
            summary.fail("Execution Result : FAILED");
        }

        extent.flush();
    }

    // Jalankan sekali sebelum semua test
    @BeforeSuite
    public void setupReport() {
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("base.url"));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Jalankan sekali setelah semua test selesai
    @AfterSuite
    public void flushReport() {
        if(extent != null){
            extent.flush();
        }
    }
}
