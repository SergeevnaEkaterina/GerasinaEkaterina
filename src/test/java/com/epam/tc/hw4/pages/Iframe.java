package com.epam.tc.hw4.pages;

import io.qameta.allure.Step;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@EqualsAndHashCode(callSuper = false)
@Data
public class Iframe extends AbstractPage {
    @FindBy(id = "frame")
    private WebElement iframe;
    @FindBy(id = "frame-button")
    private WebElement frameButton;

    public Iframe(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Step("Iframe switch")
    public void switchOn(boolean flag) {
        webDriver = (flag) ? this.webDriver.switchTo().frame(iframe) : this.webDriver.switchTo().defaultContent();
    }

    @Step("Get frame button text")
    public String getValueOfFrameButton() {
        return frameButton.getAttribute("value");
    }
}
