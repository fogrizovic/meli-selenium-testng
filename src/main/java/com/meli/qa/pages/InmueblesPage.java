package com.meli.qa.pages;

import org.openqa.selenium.By;

import static com.meli.qa.utils.SeleniumUtils.isDisplayed;

public class InmueblesPage {

    // Elements
    private static final By PUBLICAR_LNK = By.xpath("//h3[contains(text(),\"Publicar\")]");

    // Actions
    public Boolean isPublicarDisplayed() {
        return isDisplayed(PUBLICAR_LNK);
    }

}
