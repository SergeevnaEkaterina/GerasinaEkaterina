package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.tc.hw7.components.LoginForm;
import com.epam.tc.hw7.model.User;

@Url("/index.html")
@Title("Home Page")
public class HomePage extends WebPage {
    @Css("form")
    public static LoginForm loginForm;
    @Css("#user-icon")
    public static Icon userIcon;
    @Css("#user-name")
    public static Label userName;

    public static void loginAs(User user) {
        userIcon.click();
        loginForm.loginAs(user);
    }
}
