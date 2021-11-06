package com.epam.tc.hw6.data;

import com.epam.tc.hw6.model.User;
import com.epam.tc.hw6.model.UserCreator;
import org.testng.annotations.DataProvider;

public class LoginDataProvider {
    public static User roman = UserCreator.createUserRoman();

    @DataProvider
    public static Object[][] userRomanData() {
        return new Object[][]{
                {roman}
        };
    }
}
