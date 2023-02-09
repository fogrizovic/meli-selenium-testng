package com.meli.qa.driver;

import com.meli.qa.utils.PropReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public final class DriverFactory {

    private DriverFactory() {
    }

    @SneakyThrows
    public static WebDriver getDriver(String runMode, String browserName) {

        WebDriver driver = null;

        if (runMode.equalsIgnoreCase("local")) {
            if (browserName.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        } else {
            if (runMode.equalsIgnoreCase("remote")) {
                DesiredCapabilities capabilities = new DesiredCapabilities();

                if (browserName.equalsIgnoreCase("chrome")) {
                    capabilities.setBrowserName("chrome");
                } else if (browserName.equalsIgnoreCase("firefox")) {
                    capabilities.setBrowserName("firefox");
                }
                driver = new RemoteWebDriver(new URL(PropReader.getProperty("remoteurl")), capabilities);
            }
        }


        return driver;
    }
}
