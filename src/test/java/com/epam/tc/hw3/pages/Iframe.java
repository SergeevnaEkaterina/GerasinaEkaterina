package com.epam.tc.hw3.pages;

import com.epam.tc.hw3.data.LocatorsIndexPage;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class Iframe extends AbstractPage {
    @FindBy(id = LocatorsIndexPage.FRAME)
    private WebElement iframe;
    @FindBy(id = LocatorsIndexPage.FRAME_BUTTON)
    private WebElement frameButton;

    public Iframe(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void switchOn(boolean flag) {
        webDriver = (flag) ? this.webDriver.switchTo().frame(iframe) : this.webDriver.switchTo().defaultContent();
    }

    public String getValueOfFrameButton() {
        return frameButton.getAttribute(LocatorsIndexPage.ATTRIBUTE);
    }
}
