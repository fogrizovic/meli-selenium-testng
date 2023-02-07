package com.meli.qa.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import static com.meli.qa.utils.Constants.REPORT_PATH;

public final class ExtentReport {

    public static ExtentTest extentTest;
    private static ExtentReports extent;

    private ExtentReport() {
    }

    public static void initReports() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(REPORT_PATH);
        extent.attachReporter(spark);
    }

    public static void flushReports() {
        extent.flush();
    }

    public static void createTest(String name) {
        extentTest = extent.createTest(name);
        ExtentManager.setExtentTest(extentTest);
    }

    public static void assignAuthor(String authorName) {
        ExtentManager.getExtentTest().assignAuthor(authorName);
    }
}
