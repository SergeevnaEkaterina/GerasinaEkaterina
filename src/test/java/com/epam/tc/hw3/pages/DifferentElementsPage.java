package com.epam.tc.hw3.pages;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@EqualsAndHashCode(callSuper = false)
@Data
public class DifferentElementsPage extends AbstractPage {
    private List<String> logsText = new ArrayList<>();
    @FindBy(css = ".label-checkbox > input")
    private List<WebElement> checkBoxes;
    @FindBy(css = ".checkbox-row .label-radio")
    private List<WebElement> radio;
    @FindBy(css = ".uui-form-element")
    private List<WebElement> dropdownList;
    @FindBy(css = ".uui-form-element > option")
    private List<WebElement> dropdownElement;
    @FindBy(css = ".info-panel-body-log .panel-body-list > li")
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
