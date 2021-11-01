package com.epam.tc.hw4.pages;

import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@EqualsAndHashCode(callSuper = false)
@Data
public class IndexPage extends AbstractPage {
    private Iframe iframe;
    @CacheLookup
    @FindBy(className = "uui-navigation")
    private WebElement headerSection;
    @CacheLookup
    @FindBy(css = "div.row .col-sm-3")
    private List<WebElement> images;
    @CacheLookup
    @FindBy(css = "#mCSB_1_container > ul > li > a > span")
    private List<WebElement> leftSideBar;

    public IndexPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        iframe = new Iframe(webDriver);
    }

    @Step("Get header section text")
    public String getHeaderSectionText() {
        return headerSection.getText();
    }

    @Step("Get images description")
    public List<String> getDescription(List<WebElement> webElements) {
        List<String> description = new ArrayList<>();
        for (WebElement element : webElements) {
            description.add(element.getText());
        }
        return description;
    }

}
