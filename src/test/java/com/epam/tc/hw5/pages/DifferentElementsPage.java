package com.epam.tc.hw5.pages;

import com.epam.tc.hw5.data.Values;
import io.qameta.allure.Step;
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
    @FindBy(css = ".colors .uui-form-element")
    private WebElement dropdown;
    @FindBy(css = ".uui-form-element > option")
    private List<WebElement> dropdownElement;
    @FindBy(css = ".info-panel-body-log .panel-body-list > li")
    private List<WebElement> logs;

    public DifferentElementsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Step("Select checkbox {name}")
    public DifferentElementsPage selectCheckBoxes(String name) {
        checkBoxes.get(Values.CHECKBOXES.get(name)).click();
        return this;
    }

    @Step("Select radio {name}")
    public DifferentElementsPage selectRadio(String name) {
        radio.get(Values.RADIO_BUTTONS.get(name)).click();
        return this;
    }

    @Step("Select dropdown {name}")
    public DifferentElementsPage selectDropDown(String name) {
        dropdown.click();
        dropdownElement.get(Values.DROPDOWNS.get(name)).click();
        return this;
    }

    @Step("Get logs text")
    public DifferentElementsPage collectLogs() {
        for (WebElement element : logs) {
            System.out.println(element.getText());
            logsText.add(element.getText().substring(9));
        }
        return this;
    }

    @Step("Is checkbox {name} selected")
    public boolean isCheckBoxSelected(String name) {
        return checkBoxes.get(Values.CHECKBOXES.get(name)).isSelected();
    }

    @Step("Is radio {name} enabled")
    public boolean isRadioEnabled(String name) {
        return getRadio().get(Values.RADIO_BUTTONS.get(name)).isEnabled();
    }

    @Step("Is dropdown {name} selected")
    public boolean isDropDownSelected(String name) {
        return getDropdownElement().get(Values.DROPDOWNS.get(name)).isSelected();
    }
}
