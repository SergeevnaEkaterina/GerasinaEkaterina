package com.epam.tc.hw3.pages;

import com.epam.tc.hw3.data.LocatorsDifferentElementsPage;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

@Data
public class DifferentElementsPage {
    private List<String> logsText = new ArrayList<>();
    public WebDriver webDriver;
    @FindBy(css = LocatorsDifferentElementsPage.CHECKBOXES)
    private List<WebElement> checkBoxes;
    @FindBy(css = LocatorsDifferentElementsPage.RADIO)
    private List<WebElement> radio;
    @FindBy(css = LocatorsDifferentElementsPage.DROPDOWN_LIST)
    private List<WebElement> dropdown_list;
    @FindBy(css = LocatorsDifferentElementsPage.DROPDOWN_ELEMENT)
    private List<WebElement> dropdown_element;
    @FindBy(css = LocatorsDifferentElementsPage.LOGS)
    private List<WebElement> logs;

    public DifferentElementsPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public DifferentElementsPage selectCheckBoxes(int index) {
        checkBoxes.get(index).click();
        return this;
    }

    public DifferentElementsPage selectRadio(int index) {
        radio.get(index).click();
        return this;
    }

    public DifferentElementsPage selectDropDown(int outerIndex, int innerIndex) {
        dropdown_list.get(outerIndex).click();
        dropdown_element.get(innerIndex).click();
        return this;
    }

    public DifferentElementsPage collectLogs() {

        for (WebElement element : logs) {
            System.out.println(element.getText());
            logsText.add(element.getText().substring(9));
        }
        return this;
    }
}
