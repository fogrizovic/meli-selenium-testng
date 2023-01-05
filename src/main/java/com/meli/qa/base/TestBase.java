package com.meli.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static com.meli.qa.utils.TestUtil.IMPLICIT_WAIT;
import static com.meli.qa.utils.TestUtil.PAGE_LOAD_TIMEOUT;

public class TestBase {

    public static WebDriver driver;

    public static void init() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));

        driver.get("https://www.mercadolibre.com.ar/");
    }


}
