package com.epam.tc.hw6.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw6.data.Values;
import com.epam.tc.hw6.pages.DifferentElementsPage;
import com.epam.tc.hw6.pages.LoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class SiteInnerPageSteps {
    SoftAssert softAssert = new SoftAssert();
    protected LoginPage loginPage;
    protected DifferentElementsPage differentPage;

    public SiteInnerPageSteps(WebDriver webDriver) {
        loginPage = new LoginPage(webDriver);
        differentPage = new DifferentElementsPage(webDriver);
    }

    @Step("Open by url")
    public void openByUrl(String url) {
        loginPage.open(url);
    }

    @Step("Assert title")
    public void assertTitle() {
        softAssert.assertEquals(loginPage.getSiteTitle(), Values.TITLE);
    }

    @Step("Perform login {login} : {password}")
    public void performLogin(String login, String password) {
        loginPage.login(login, password);
    }

    @Step("Assert username {username} loggined")
    public void assertUserName(String username) {
        softAssert.assertTrue(loginPage.getUserName().isDisplayed());
        softAssert.assertEquals(loginPage.getUserNameText(), username);
    }

    @Step("Open differentElements page")
    public void openInnerPage() {
        loginPage.openDifferentElements();
    }

    @Step("Select checkboxes")
    public void selectCheckBoxes() {
        differentPage
                .selectCheckBoxes(0)
                .selectCheckBoxes(2);
        assertThat(differentPage.isCheckBoxSelected(0)
                && differentPage.isCheckBoxSelected(2)).isTrue();
    }

    @Step("Select radio")
    public void selectRadio() {
        assertThat(differentPage
                .selectRadio(3)
                .isRadioEnabled(3))
                .isTrue();
    }

    @Step("Select in dropDown")
    public void selectInDropDown() {
        assertThat(differentPage.selectDropDown(2, 3)
                .isDropDownSelected(3))
                .isTrue();
    }

    @Step("Logs check")
    public void logsCheck() {
        assertThat(differentPage
                .collectLogs()
                .getLogsText())
                .isEqualTo(Values.LOGS);
    }
}
