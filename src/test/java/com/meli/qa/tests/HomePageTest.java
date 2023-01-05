package com.meli.qa.tests;

import com.meli.qa.base.TestBase;
import com.meli.qa.pages.HomePage;
import com.meli.qa.pages.InmueblesPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    HomePage homePage;
    InmueblesPage inmueblesPage;

    @BeforeMethod
    public void setup() {
        init();
        homePage = new HomePage();
        inmueblesPage = new InmueblesPage();
    }

    @Test
    public void shouldOpenInmueblesPageFromMenu() {
        inmueblesPage = homePage.header()
                .selectCategory("Inmuebles");

        inmueblesPage
                .verifyPublicarLinkIsPresent();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
