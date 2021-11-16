package com.epam.tc.hw7.data;

import com.epam.tc.hw7.model.User;

public class UserCreator {
    public static final String LOGIN = PropertyInitialization.getPropertyByName("login");
    public static final String PASSWORD = PropertyInitialization.getPropertyByName("password");
    public static final String USERNAME = PropertyInitialization.getPropertyByName("userName");

    public static User createUserRoman() {
        return new User(LOGIN, PASSWORD, USERNAME);
    }
}
