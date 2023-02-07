package com.meli.qa.listeners;

import com.meli.qa.annotations.FrameworkAnnotation;
import com.meli.qa.reports.ExtentLogger;
import com.meli.qa.reports.ExtentReport;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getName());
        ExtentReport.assignAuthor(result.getMethod().getConstructorOrMethod()
                .getMethod().getAnnotation(FrameworkAnnotation.class).author());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getName() + " passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getName() + " failed");
        ExtentLogger.fail(result.getThrowable().getMessage());
        ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
    }

    @Override
    public void onStart(ITestContext context) {
        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReport.flushReports();
    }
}
