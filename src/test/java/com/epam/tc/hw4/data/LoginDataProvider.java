package com.epam.tc.hw4.data;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {
    public static final String LOGIN = PropertyInitialization.getPropertyByName("login");
    public static final String PASSWORD = PropertyInitialization.getPropertyByName("password");
    public static final String USERNAME = PropertyInitialization.getPropertyByName("userName");

    @DataProvider
    public static Object[][] userRomanData() {
        return new Object[][]{
                {LOGIN, PASSWORD, USERNAME}
        };
    }
}
