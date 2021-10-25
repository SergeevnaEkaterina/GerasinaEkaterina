package com.epam.tc.hw3.pages;

import java.util.ArrayList;
import java.util.List;

import com.epam.tc.hw3.data.LocatorsIndexPage;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class IndexPage {
    public WebDriver webDriver;
    @CacheLookup
    @FindBy(className = LocatorsIndexPage.HEADER_SECTION)
    private WebElement headerSection;
    @CacheLookup
    @FindBy(css = LocatorsIndexPage.IMAGES)
    private List<WebElement> images;
    @FindBy(id = LocatorsIndexPage.FRAME)
    private WebElement iframe;
    @FindBy(id = LocatorsIndexPage.FRAME_BUTTON)
    private WebElement frameButton;
    @CacheLookup
    @FindBy(css = LocatorsIndexPage.LEFT_SIDE_BAR)
    private List<WebElement> leftSideBar;

    public IndexPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }


    public String getHeaderSectionText() {
        return headerSection.getText();
    }

    public void switchOn(boolean flag) {
        webDriver = (flag) ? this.webDriver.switchTo().frame(iframe) : this.webDriver.switchTo().defaultContent();
    }

    public String getValueOfFrameButton() {
        return frameButton.getAttribute(LocatorsIndexPage.ATTRIBUTE);
    }

    public List<String> getDescription(List<WebElement> webElements) {
        List<String> description = new ArrayList<>();
        for (WebElement element : webElements) {
            description.add(element.getText());
        }
        return description;
    }

}
