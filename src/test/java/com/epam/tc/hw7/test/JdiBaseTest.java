package com.epam.tc.hw7.test;

import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.tc.hw7.pages.JdiSite.login;
import static com.epam.tc.hw7.pages.JdiSite.logout;
import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw7.data.PropertyInitialization;
import com.epam.tc.hw7.data.UserCreator;
import com.epam.tc.hw7.model.User;
import com.epam.tc.hw7.pages.HomePage;
import com.epam.tc.hw7.pages.JdiSite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class JdiBaseTest {
    public static final User USER_ROMAN = UserCreator.createUserRoman();
    public static final String HEADER_MENU = PropertyInitialization.getPropertyByName("header");

    @BeforeSuite
    static void setUpSuite() {
        initSite(JdiSite.class);
    }

    @BeforeMethod
    static void setUpMethod() {
        login(USER_ROMAN);
        assertThat(HomePage.userName.text())
               .isEqualTo(USER_ROMAN.getUserName());
    }

    @AfterMethod(alwaysRun = true)
    static void teardown() {
        logout();
    }
}
