package com.meli.qa.driver;

import com.meli.qa.utils.PropReader;
import org.openqa.selenium.WebDriver;

import static com.meli.qa.driver.DriverManager.getDriver;
import static com.meli.qa.driver.DriverManager.setDriver;
import static com.meli.qa.utils.SeleniumUtils.IMPLICIT_WAIT;
import static com.meli.qa.utils.SeleniumUtils.PAGE_LOAD_TIMEOUT;

public final class Driver {

    private Driver() {
    }

    public static void initDriver() {
        if (getDriver() == null) {
            WebDriver driver = DriverFactory.getDriver(PropReader.getProperty("browser"));
            setDriver(driver);
            getDriver().manage().window().maximize();
            getDriver().manage().deleteAllCookies();
            getDriver().manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT);
            getDriver().manage().timeouts().implicitlyWait(IMPLICIT_WAIT);
            getDriver().get(PropReader.getProperty("baseUrl"));
        }
    }

    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            setDriver(null);
        }

    }
}
