package com.meli.qa.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.meli.qa.utils.SeleniumUtils.getText;

public class ItemComp {

    // Elements
    public static final By TITLE = By.cssSelector("h2");
    private WebElement rootElement;

    public ItemComp(WebElement root) {
        rootElement = root;
    }

    // Actions
    public String getTitle() {
        return getText(rootElement.findElement(TITLE));
    }
}
