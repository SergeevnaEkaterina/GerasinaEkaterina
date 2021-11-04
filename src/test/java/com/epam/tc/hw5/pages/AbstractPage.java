package com.epam.tc.hw5.pages;

import io.qameta.allure.Step;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

@NoArgsConstructor
public abstract class AbstractPage {
    protected WebDriver webDriver;

    public AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Get site title")
    public String getSiteTitle() {
        return webDriver.getTitle();
    }
}
