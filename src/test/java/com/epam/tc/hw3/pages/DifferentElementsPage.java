package com.epam.tc.hw3.pages;

import com.epam.tc.hw3.data.LocatorsDifferentElementsPage;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class DifferentElementsPage extends AbstractPage {
    private List<String> logsText = new ArrayList<>();

    @FindBy(css = LocatorsDifferentElementsPage.CHECKBOXES)
    private List<WebElement> checkBoxes;
    @FindBy(css = LocatorsDifferentElementsPage.RADIO)
    private List<WebElement> radio;
    @FindBy(css = LocatorsDifferentElementsPage.DROPDOWN_LIST)
    private List<WebElement> dropdownList;
    @FindBy(css = LocatorsDifferentElementsPage.DROPDOWN_ELEMENT)
    private List<WebElement> dropdownElement;
    @FindBy(css = LocatorsDifferentElementsPage.LOGS)
    private List<WebElement> logs;

    public DifferentElementsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);

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
        dropdownList.get(outerIndex).click();
        dropdownElement.get(innerIndex).click();
        return this;
    }

    public DifferentElementsPage collectLogs() {
        for (WebElement element : logs) {
            System.out.println(element.getText());
            logsText.add(element.getText().substring(9));
        }
        return this;
    }

    public boolean isCheckBoxSelected(int index) {
        return getCheckBoxes().get(index).isSelected();
    }

    public boolean isRadioEnabled(int index) {
        return getRadio().get(index).isEnabled();
    }

    public boolean isDropDownSelected(int index) {
        return getDropdownElement().get(index).isSelected();
    }
}
