package com.meli.qa.tests;

import com.meli.qa.annotations.FrameworkAnnotation;
import com.meli.qa.pages.HomePage;
import com.meli.qa.pages.ListingsPage;
import com.meli.qa.utils.ExcelReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchTest extends TestBase {

    HomePage homePage;
    ListingsPage listingsPage;

    @DataProvider
    public static Object[][] getData() {
        return new Object[][]{
                {"Cafetera"},
                {"Tostadora"}
        };
    }

    @DataProvider
    public static Object[][] getExcelData() throws IOException {
        return ExcelReader.readFile("testData.xlsx", "sheet1");
    }

    @BeforeMethod
    public void setup() {
        homePage = new HomePage();
    }

    @FrameworkAnnotation(author = "fogrizovic")
    @Test(description = "should display results when searching for product from Home page", dataProvider = "getExcelData")
    public void shouldDisplayResultsWhenSearching(String productName) {
        listingsPage = homePage
                .header()
                .searchProduct(productName);

        String firstItemTitle = listingsPage.getItems().get(0).getTitle();
        Assert.assertTrue(firstItemTitle.contains(productName));
    }

}
