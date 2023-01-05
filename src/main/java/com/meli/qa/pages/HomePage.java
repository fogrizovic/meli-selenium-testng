package com.meli.qa.pages;

import com.meli.qa.base.TestBase;
import com.meli.qa.pages.comp.HeaderComp;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.openqa.selenium.support.PageFactory;

@Accessors(fluent = true)
@Getter
public class HomePage extends TestBase {

    HeaderComp header;

    public HomePage() {
        PageFactory.initElements(driver, this);
        header = new HeaderComp();
    }

}
