package com.meli.qa.pages.components;

import com.meli.qa.pages.InmueblesPage;
import com.meli.qa.pages.ListingsPage;
import org.openqa.selenium.By;

import static com.meli.qa.utils.SeleniumUtils.*;

public class HeaderComp {

    // Elements
    private static final By SEARCH_BOX_IPT = By.cssSelector("#cb1-edit");
    private static final By SEARCH_BOX_SUBMIT_BTN = By.cssSelector("button[type=submit]");
    private static final By CATEGORIES_LNK = By.cssSelector(".nav-menu-categories-link");
    private static String categoryLi = "//li[./a[contains(text(),\"%replace_text%\")]]";

    // Actions
    public ListingsPage searchProduct(String product) {
        sendKeys(SEARCH_BOX_IPT, product, "product input");
        click(SEARCH_BOX_SUBMIT_BTN, "search button");

        return new ListingsPage();
    }

    public InmueblesPage selectCategory(String category) {
        moveToElement(CATEGORIES_LNK, "categories menu");
        click(By.xpath(categoryLi.replaceAll("%replace_text%", category)), "category option");

        return new InmueblesPage();
    }

}
