package com.epam.tc.hw7.components;

import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.tc.hw7.model.MetalsAndColors;
import com.google.common.base.Functions;
import io.qameta.allure.Step;
import java.util.List;
import java.util.stream.Collectors;

public class MetalsAndColorsForm extends Form<MetalsAndColors> {
    private String deselectOption = "Vegetables";
    @JDropdown(root = "div#colors", value = ".filter-option", list = "li", expand = ".caret")
    private static Dropdown dropDownForColor;
    @JDropdown(root = "div#metals", value = ".filter-option", list = "li", expand = ".caret")
    private static Dropdown dropDownForMetals;
    @JDropdown(root = "#vegetables", value = ".filter-option", list = "li", expand = ".caret")
    private static Dropdown dropDownForVegetables;
    @UI("section.horizontal-group input")
    private static RadioButtons buttonsInSummary;
    @UI("#elements-checklist input")
    private static Checklist checkBoxes;
    @UI("button#submit-button")
    private static Button submit;

    private void selectElementsAccordingToJson(Dropdown elements, String s) {
        elements.select(s);
    }

    private void selectElementsAccordingToJson(Dropdown elements, List<String> s) {
        s.forEach(elements::select);
    }

    private void selectElementsAccordingToJson(UIListBase<?> elements, List<?> objectList) {
        List<String> strings = objectList.stream().map(Functions.toStringFunction()).collect(Collectors.toList());
        strings.forEach(elements::select);
    }

    @Override
    public void fill(MetalsAndColors metalsAndColors) {

        selectElementsAccordingToJson(buttonsInSummary, metalsAndColors
                .getSummary()
                .stream()
                .map(Functions
                        .toStringFunction())
                .collect(Collectors
                        .toList()));
        selectElementsAccordingToJson(checkBoxes, metalsAndColors.getElements());
        selectElementsAccordingToJson(dropDownForColor, metalsAndColors.getColor());
        selectElementsAccordingToJson(dropDownForMetals, metalsAndColors.getMetals());
        selectElementsAccordingToJson(dropDownForVegetables, deselectOption);
        selectElementsAccordingToJson(dropDownForVegetables, metalsAndColors.getVegetables());

    }

    @Override
    public void submit() {
        submit.click();
    }

    @Step("Fill form Metals & Colors by JSON data")
    public void fillForm(MetalsAndColors metalsAndColors) {
        fill(metalsAndColors);
        submit();
    }

}
