package com.epam.tc.hw6.tests;

import com.epam.tc.hw6.data.LoginDataProvider;
import com.epam.tc.hw6.listener.ListenerScreenshot;
import com.epam.tc.hw6.steps.StartPageSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Feature("Start page functionality")
@Story("Checking items and iframe")
@Listeners(ListenerScreenshot.class)
public class StartPageTest extends SiteBaseTest {
    SoftAssert softAssert = new SoftAssert();

    @Test(dataProviderClass = LoginDataProvider.class, dataProvider = "userRomanData")
    @Description("Test of start page")
    public void startPageJdiTest(String login, String password, String username) {
        StartPageSteps startPageSteps = new StartPageSteps(webDriver);
        startPageSteps.openByUrl(URL);
        softAssert.assertEquals(webDriver.getCurrentUrl(), URL);
        pageID = webDriver.getWindowHandle();
        // 2. Assert Browser title
        startPageSteps.assertTitle();
        // 3. Perform login
        startPageSteps.performLogin(login, password);
        // 4. Assert Username is loggined
        startPageSteps.assertUserName(username);
        // 5. Assert there are 4 items on the header section are displayed with proper texts
        startPageSteps.headerSection();
        // 6. Assert that there are 4 images on the Index Page and they are displayed
        startPageSteps.assertImages();
        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        startPageSteps.assertImagesDescription();
        // 8. Assert that there is the iframe with “Frame Button” exist
        startPageSteps.assertIframe();
        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        startPageSteps.checkIframe();
        // 10. Switch to original window back
        startPageSteps.switchBackToOriginal();
        softAssert.assertEquals(webDriver.getWindowHandle(), pageID);
        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        startPageSteps.assertLeftSection();
        // 12. Close Browser in after method
        softAssert.assertAll();
        startPageSteps.assertAllAssertions();
    }
}

