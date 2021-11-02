package com.epam.tc.hw5.steps;

import com.epam.tc.hw4.data.PropertyInitialization;
import com.epam.tc.hw5.context.TestContext;
import com.epam.tc.hw5.pages.DifferentElementsPage;
import com.epam.tc.hw5.pages.IndexPage;
import com.epam.tc.hw5.pages.LoginPage;
import com.epam.tc.hw5.pages.UserTablePage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractBaseSteps {
    public static final String URL = PropertyInitialization.getPropertyByName("url");
    public static final String LOGIN = PropertyInitialization.getPropertyByName("login");
    public static final String PASSWORD = PropertyInitialization.getPropertyByName("password");
    public static final String USERNAME = PropertyInitialization.getPropertyByName("userName");
    protected LoginPage loginPage;
    protected DifferentElementsPage differentElementsPage;
    protected IndexPage indexPage;
    protected UserTablePage userTablePage;

    public AbstractBaseSteps() {
        WebDriver webdriver = TestContext.getInstance().getObject("driver");
        loginPage = new LoginPage(webdriver);
        differentElementsPage = new DifferentElementsPage(webdriver);
        indexPage = new IndexPage(webdriver);
        userTablePage = new UserTablePage(webdriver);
    }
}
