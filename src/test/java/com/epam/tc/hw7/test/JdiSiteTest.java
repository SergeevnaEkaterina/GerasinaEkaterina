package com.epam.tc.hw7.test;

import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.tc.hw7.pages.JdiSite.homePage;
import static com.epam.tc.hw7.pages.JdiSite.metalsAndColorsPage;
import static com.epam.tc.hw7.pages.MetalsAndColorsPage.listLogs;
import static com.epam.tc.hw7.pages.MetalsAndColorsPage.metalsAndColorsForm;
import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw7.data.ExpectedJsonInfo;
import com.epam.tc.hw7.data.InfoDataProvider;
import com.epam.tc.hw7.data.PropertyInitialization;
import com.epam.tc.hw7.data.UserCreator;
import com.epam.tc.hw7.model.MetalsAndColors;
import com.epam.tc.hw7.model.User;
import com.epam.tc.hw7.pages.HomePage;
import com.epam.tc.hw7.pages.JdiSite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class JdiSiteTest {
    public static final User USER_ROMAN = UserCreator.createUserRoman();
    public static final String HEADER_MENU = PropertyInitialization.getPropertyByName("header");

    @BeforeSuite
    static void setUpSuite() {
        initSite(JdiSite.class);
    }

    @BeforeMethod
    static void setUpMethod() {
        homePage.loginAs(USER_ROMAN);
        assertThat(HomePage.userName.text())
                .isEqualTo(USER_ROMAN.getUserName());
    }

    @AfterMethod(alwaysRun = true)
    static void teardown() {
        homePage.logout();
    }

    @Test(dataProvider = "jsonData", dataProviderClass = InfoDataProvider.class)
    public void metalsAndColorsTest(MetalsAndColors metalsAndColors) {
        homePage.selectMenu(HEADER_MENU);
        metalsAndColorsPage.checkOpened();
        metalsAndColorsForm.fillForm(metalsAndColors);
        assertThat(listLogs())
                .isEqualTo(ExpectedJsonInfo.formJsonInfoToList(metalsAndColors));
    }
}
