package com.sdd.pesanruang.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;
    public static ExtentReports getInstance() {
        if (extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter("reports/TestReport.html");

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo("Automation", "Pesan Ruang");
            extent.setSystemInfo("Tester", "Putri");
        }

        return extent;
    }
}
