package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.tc.hw7.components.MetalsAndColorsForm;
import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.List;

@Url("/metals-colors.html")
@Title("Metal and Colors")
public class MetalsAndColorsPage extends WebPage {

    @Css("form")
    public static MetalsAndColorsForm metalsAndColorsForm;

    @Css(".results li")
    private static List<Label> logs;

    @Step("Get result section logs")
    public static List<String> listLogs() {
        List<String> logsText = new ArrayList<>();
        for (Label element : logs) {
            System.out.println(element.getText());
            logsText.add(element.getText());
        }
        return logsText;
    }
}
