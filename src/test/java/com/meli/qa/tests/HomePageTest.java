package com.meli.qa.tests;

import com.meli.qa.annotations.FrameworkAnnotation;
import com.meli.qa.pages.HomePage;
import com.meli.qa.pages.InmueblesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    HomePage homePage;
    InmueblesPage inmueblesPage;

    @BeforeMethod
    public void setup() {
        homePage = new HomePage();
    }

    @FrameworkAnnotation(author = "fogrizovic")
    @Test(description = "Should open Inmuebles page from Home page menu")
    public void shouldOpenInmueblsesPageFromMenu() {
        inmueblesPage = homePage.header()
                .selectCategory("Inmuebles");

        Assert.assertTrue(inmueblesPage.isPublicarDisplayed());
    }

}
