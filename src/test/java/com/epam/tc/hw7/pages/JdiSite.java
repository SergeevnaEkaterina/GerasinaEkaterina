package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.tc.hw7.model.User;
import io.qameta.allure.Step;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {
    public static HomePage homePage;
    public static MetalsAndColorsPage metalsAndColorsPage;
    @UI(".m-l8 li")
    public static Menu headerMenu;
    @Css("#user-icon")
    public static Icon userIcon;
    @UI(".btn-login")
    public static Button logout;

    public static void open() {
        homePage.open();
    }

    public static void logout() {
        userIcon.click();
        logout.click();
    }

    @Step("Login on JDI site as User")
    public static void login(User user) {
        open();
        HomePage.loginAs(user);
    }

    @Step("Open Metals & Colors page by {string} menu")
    public static void selectMenu(String value) {
        headerMenu.select(value);
    }
}
