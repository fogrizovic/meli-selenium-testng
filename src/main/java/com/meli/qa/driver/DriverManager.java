package com.meli.qa.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        return threadLocal.get();
    }

    public static void setDriver(WebDriver driver) {
        threadLocal.set(driver);
    }
}
