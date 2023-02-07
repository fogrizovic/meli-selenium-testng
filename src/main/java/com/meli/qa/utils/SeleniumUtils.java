package com.meli.qa.utils;

import com.meli.qa.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.meli.qa.driver.DriverManager.getDriver;

public class SeleniumUtils {

    public static Duration PAGE_LOAD_TIMEOUT = Duration.ofSeconds(20);
    public static Duration IMPLICIT_WAIT = Duration.ofSeconds(10);
    public static Duration EXPLICIT_WAIT = Duration.ofSeconds(10);

    public static void click(By by, String elementName) {
        WebElement element = waitUntilElementPresent(by);
        element.click();
        ExtentLogger.pass(elementName + " clicked successfully");
    }

    public static void sendKeys(By by, String value, String elementName) {
        WebElement element = waitUntilElementPresent(by);
        element.sendKeys(value);
        ExtentLogger.pass(value + " entered successfully in " + elementName);
    }

    public static void moveToElement(By by, String elementName) {
        WebElement element = waitUntilElementPresent(by);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).build().perform();
        ExtentLogger.pass("Moved successfully to " + elementName);
    }

    public static Boolean isDisplayed(By by) {
        return getDriver().findElement(by).isDisplayed();
    }

    public static String getText(By by) {
        WebElement element = waitUntilElementPresent(by);
        return element.getText();
    }

    public static String getText(WebElement element) {
        return element.getText();
    }

    // Waits
    public static WebElement waitUntilElementPresent(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), EXPLICIT_WAIT);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

}
