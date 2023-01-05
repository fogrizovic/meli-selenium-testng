package com.meli.qa.pages.comp;

import com.meli.qa.base.TestBase;
import com.meli.qa.pages.InmueblesPage;
import com.meli.qa.pages.ListingsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderComp extends TestBase {

    // Elements
    @FindBy(css = "#cb1-edit")
    WebElement searchBoxInput;
    @FindBy(css = "button[type=submit]")
    WebElement searchBoxSubmitButton;
    @FindBy(css = ".nav-menu-categories-link")
    WebElement categoriesLink;

    public HeaderComp() {
        PageFactory.initElements(driver, this);
    }

    // Actions
    public ListingsPage searchProduct(String product) {
        searchBoxInput.sendKeys(product);
        searchBoxSubmitButton.click();

        return new ListingsPage();
    }

    public InmueblesPage selectCategory(String category) {
        Actions actions = new Actions(driver);
        actions.moveToElement(categoriesLink).build().perform();

        driver.findElement(By.xpath("//li[./a[contains(text(),\"" + category + "\")]]")).click();

        return new InmueblesPage();
    }

}
