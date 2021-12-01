package com.epam.tc.hw7.components;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import com.epam.tc.hw7.model.User;

public class LoginForm extends Form<User> {
    @Css("#name")
    TextField login;
    @Css("#password")
    TextField password;
    @Css("#login-button")
    Button submit;
}
