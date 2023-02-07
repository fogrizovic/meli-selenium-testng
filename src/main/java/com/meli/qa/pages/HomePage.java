package com.meli.qa.pages;

import com.meli.qa.pages.components.HeaderComp;
import lombok.Getter;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Getter
public class HomePage {

    HeaderComp header;

    public HomePage() {
        header = new HeaderComp();
    }

}
