package com.epam.tc.hw3.pages;

import com.epam.tc.hw3.data.LocatorsIndexPage;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class IndexPage extends AbstractPage {
    private Iframe iframe;
    @CacheLookup
    @FindBy(className = LocatorsIndexPage.HEADER_SECTION)
    private WebElement headerSection;
    @CacheLookup
    @FindBy(css = LocatorsIndexPage.IMAGES)
    private List<WebElement> images;
    @CacheLookup
    @FindBy(css = LocatorsIndexPage.LEFT_SIDE_BAR)
    private List<WebElement> leftSideBar;

    public IndexPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        iframe = new Iframe(webDriver);
    }

    public String getHeaderSectionText() {
        return headerSection.getText();
    }

    public List<String> getDescription(List<WebElement> webElements) {
        List<String> description = new ArrayList<>();
        for (WebElement element : webElements) {
            description.add(element.getText());
        }
        return description;
    }

}
