package com.epam.tc.hw2.exercise1;

import com.epam.tc.hw2.SiteBaseTest;
import com.epam.tc.hw2.data.LocatorsIframe;
import com.epam.tc.hw2.data.LocatorsIndexPage;
import com.epam.tc.hw2.data.Values;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class StartPageTest extends SiteBaseTest {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void startPageJdiTest() {
        webDriver.navigate().to(URL);
        softAssert.assertEquals(webDriver.getCurrentUrl(), URL);
        final String pageID = webDriver.getWindowHandle();
        // 2. Assert Browser title
        softAssert.assertEquals(webDriver.getTitle(), Values.TITLE);
        webDriver.findElement(LocatorsIndexPage.USER_ICON).click();
        WebElement username = webDriver.findElement(LocatorsIndexPage.NAME);
        WebElement password = webDriver.findElement(LocatorsIndexPage.PASSWORD);
        // 3. Perform login
        username.sendKeys(LOGIN);
        password.sendKeys(PASSWORD);
        webDriver.findElement(LocatorsIndexPage.LOGIN_BUTTON).click();
        WebElement userName = webDriver.findElement(LocatorsIndexPage.USERNAME);
        // 4. Assert Username is loggined
        softAssert.assertTrue(userName.isDisplayed());
        softAssert.assertEquals(userName.getText(), USERNAME);
        // 5. Assert there are 4 items on the header section are displayed with proper texts
        softAssert.assertTrue(webDriver.findElements(LocatorsIndexPage.HEADER_SECTION).get(0).isDisplayed());
        softAssert.assertEquals(webDriver.findElements(LocatorsIndexPage.HEADER_SECTION).get(0).getText(),
                Values.HEADER);
        // 6. Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertEquals(webDriver.findElements(LocatorsIndexPage.IMAGES).size(), 4);
        List<String> description = new ArrayList<>();
        for (WebElement element : webDriver.findElements(LocatorsIndexPage.DESCRIPTION)) {
            description.add(element.getText());
        }
        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        softAssert.assertEquals(description, Values.DESCRIPTION);
        WebElement iframe = webDriver.findElement(LocatorsIframe.FRAME);
        // 8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(iframe.isDisplayed());
        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame(iframe);
        softAssert.assertEquals(webDriver.findElement(LocatorsIframe.FRAME_BUTTON)
                .getAttribute(LocatorsIframe.ATTRIBUTE), Values.FRAME_BUTTON);
        // 10. Switch to original window back
        webDriver.switchTo().defaultContent();
        softAssert.assertEquals(webDriver.getWindowHandle(), pageID);
        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<String> leftSideBar = new ArrayList<>();
        for (WebElement element : webDriver.findElements(LocatorsIndexPage.LEFT_SIDE_BAR)) {
            leftSideBar.add(element.getText());
        }
        softAssert.assertEquals(leftSideBar, Values.LEFT_SIDE_BAR);
        // 12. Close Browser in after method
        softAssert.assertAll();
    }
}
