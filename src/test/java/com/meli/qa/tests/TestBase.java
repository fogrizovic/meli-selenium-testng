package com.meli.qa.tests;

import com.meli.qa.driver.Driver;
import com.meli.qa.listeners.TestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.lang.reflect.Method;

@Listeners(TestListener.class)
public class TestBase {

    @BeforeMethod
    public void setUp(Method method) {
        Driver.initDriver();
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }


}
