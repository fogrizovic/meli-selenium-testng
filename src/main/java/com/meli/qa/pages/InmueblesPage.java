package com.meli.qa.pages;

import com.meli.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class InmueblesPage extends TestBase {

    // Elements
    @FindBy(xpath = "//h3[contains(text(),\"Publicar\")]")
    WebElement publicarLink;

    public InmueblesPage() {
        PageFactory.initElements(driver, this);
    }

    // Actions
    public InmueblesPage verifyPublicarLinkIsPresent() {
        Assert.assertTrue(publicarLink.isDisplayed());
        return this;
    }
}
