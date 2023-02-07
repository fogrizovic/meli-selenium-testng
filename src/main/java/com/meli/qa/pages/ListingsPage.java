package com.meli.qa.pages;

import com.meli.qa.pages.components.ItemComp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.meli.qa.driver.DriverManager.getDriver;

public class ListingsPage {

    // Elements
    private static final By ITEMS = By.cssSelector("li[class=\"ui-search-layout__item shops__layout-item\"]");

    public List<ItemComp> getItems() {
        List<WebElement> itemElements = getDriver().findElements(ITEMS);
        return itemElements.stream()
                .map(itemElement -> new ItemComp(itemElement))
                .collect(Collectors.toList());
    }

}
