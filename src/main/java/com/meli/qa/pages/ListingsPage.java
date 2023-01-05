package com.meli.qa.pages;

import com.meli.qa.base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class ListingsPage extends TestBase {

    public ListingsPage() {
        PageFactory.initElements(driver, this);
    }
}
