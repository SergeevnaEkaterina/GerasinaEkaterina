package com.epam.tc.hw5.pages;

import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

@NoArgsConstructor
public abstract class AbstractPage {
    protected WebDriver webDriver;

    public AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}