package com.epam.tc.hw4.steps;

import com.epam.tc.hw4.data.Values;
import com.epam.tc.hw4.pages.IndexPage;
import com.epam.tc.hw4.pages.LoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class StartPageSteps {
    SoftAssert softAssert = new SoftAssert();
    protected LoginPage loginPage;
    protected IndexPage indexPage;


    public StartPageSteps(WebDriver webDriver) {
        loginPage = new LoginPage(webDriver);
        indexPage = new IndexPage(webDriver);
    }

    @Step("Open login page")
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

    @Step("Assert 4 items on header section displayed with proper texts")
    public void headerSection() {
        softAssert.assertTrue(indexPage.getHeaderSection().isDisplayed());
        softAssert.assertEquals(indexPage.getHeaderSectionText(),
                Values.HEADER);
    }

    @Step("Assert 4 images displayed")
    public void assertImages() {
        softAssert.assertEquals(indexPage.getImages().size(), 4);
    }


    @Step("Assert images description")
    public void assertImagesDescription() {
        softAssert.assertEquals(indexPage.getDescription(indexPage.getImages()), Values.DESCRIPTION);
    }


    @Step("Assert iframe with button exist")
    public void assertIframe() {
        softAssert.assertTrue(indexPage.getIframe().getIframe().isDisplayed());
    }

    @Step("Switch to iFrame and check button")
    public void checkIframe() {
        indexPage.getIframe().switchOn(true);
        softAssert.assertEquals(indexPage.getIframe().getValueOfFrameButton(), Values.FRAME_BUTTON);
    }

    @Step("Switch back to original window")
    public void switchBackToOriginal() {
        indexPage.getIframe().switchOn(false);
    }

    @Step("Assert 5 items in left section")
    public void assertLeftSection() {
        softAssert.assertEquals(indexPage.getDescription(indexPage.getLeftSideBar()), Values.LEFT_SIDE_BAR);
    }

}
