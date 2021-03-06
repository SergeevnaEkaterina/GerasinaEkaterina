package com.epam.tc.hw3.exercise1;

import com.epam.tc.hw3.SiteBaseTest;
import com.epam.tc.hw3.data.LoginDataProvider;
import com.epam.tc.hw3.data.Values;
import com.epam.tc.hw3.pages.IndexPage;
import com.epam.tc.hw3.pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class StartPageTest extends SiteBaseTest {
    SoftAssert softAssert = new SoftAssert();

    @Test(dataProviderClass = LoginDataProvider.class, dataProvider = "userRomanData")
    public void startPageJdiTest(String login, String password, String username) {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.open(URL);
        softAssert.assertEquals(webDriver.getCurrentUrl(), URL);
        pageID = webDriver.getWindowHandle();
        // 2. Assert Browser title
        softAssert.assertEquals(loginPage.getSiteTitle(), Values.TITLE);
        // 3. Perform login
        loginPage.login(login, password);
        // 4. Assert Username is loggined
        softAssert.assertTrue(loginPage.getUserName().isDisplayed());
        softAssert.assertEquals(loginPage.getUserNameText(), username);
        IndexPage indexPage = new IndexPage(webDriver);
        // 5. Assert there are 4 items on the header section are displayed with proper texts
        softAssert.assertTrue(indexPage.getHeaderSection().isDisplayed());
        softAssert.assertEquals(indexPage.getHeaderSectionText(),
                Values.HEADER);
        // 6. Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertEquals(indexPage.getImages().size(), 4);
        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        softAssert.assertEquals(indexPage.getDescription(indexPage.getImages()), Values.DESCRIPTION);
        // 8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(indexPage.getIframe().getIframe().isDisplayed());
        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        indexPage.getIframe().switchOn(true);
        //  webDriver.switchTo().frame(indexPage.getIframe());
        softAssert.assertEquals(indexPage.getIframe().getValueOfFrameButton(), Values.FRAME_BUTTON);
        // 10. Switch to original window back
        indexPage.getIframe().switchOn(false);
        softAssert.assertEquals(webDriver.getWindowHandle(), pageID);
        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        softAssert.assertEquals(indexPage.getDescription(indexPage.getLeftSideBar()), Values.LEFT_SIDE_BAR);
        // 12. Close Browser in after method
        softAssert.assertAll();
    }
}
