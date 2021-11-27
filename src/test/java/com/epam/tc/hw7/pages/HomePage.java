package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.tc.hw7.components.LoginForm;
import com.epam.tc.hw7.model.User;
import io.qameta.allure.Step;

@Url("/index.html")
@Title("Home Page")
public class HomePage extends WebPage {
    @Css("form")
    public static LoginForm loginForm;
    @Css("#user-icon")
    public static Icon userIcon;
    @Css("#user-name")
    public static Label userName;
    @UI(".m-l8 li")
    public static Menu headerMenu;

    @UI(".btn-login")
    public static Button logout;

    public void logout() {
        userIcon.click();
        logout.click();
    }

    @Step("Open Metals & Colors page by {string} menu")
    public void selectMenu(String value) {
        headerMenu.select(value);
    }

    public void loginAs(User user) {
        open();
        userIcon.click();
        loginForm.loginAs(user);
    }
}
