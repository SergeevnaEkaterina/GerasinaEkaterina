package com.epam.tc.hw2.data;

import org.openqa.selenium.By;

public class LocatorsDifferentElementsPage {
    public static final By SERVICE = By.linkText("SERVICE");
    public static final By DIFF_ELEMENTS = By.linkText("DIFFERENT ELEMENTS");
    public static final By CHECKBOXES = By.cssSelector(".label-checkbox > input");
    public static final By RADIO = By.cssSelector(".checkbox-row .label-radio");
    public static final By DROPDOWN_LIST = By.cssSelector(".uui-form-element");
    public static final By DROPDOWN_ELEMENT = By.cssSelector(".uui-form-element > option");
    public static final By LOGS = By.cssSelector(".info-panel-body-log .panel-body-list > li");

}
