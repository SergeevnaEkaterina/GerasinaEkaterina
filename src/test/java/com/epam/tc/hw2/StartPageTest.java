package com.epam.tc.hw2;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class StartPageTest extends SiteBaseTest {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void startPageJdiTest() {
        // 1. Open test site by URL
        webDriver.navigate().to(URL);
        softAssert.assertEquals(webDriver.getCurrentUrl(), URL);
        final String pageID = webDriver.getWindowHandle();

        // 2. Assert Browser title
        softAssert.assertEquals(webDriver.getTitle(), "Home Page");
        webDriver.findElement(By.id("user-icon")).click();
        WebElement username = webDriver.findElement(By.id("name"));
        WebElement password = webDriver.findElement(By.id("password"));
        // 3. Perform login
        username.sendKeys(LOGIN);
        password.sendKeys(PASSWORD);
        webDriver.findElement(By.id("login-button")).click();
        WebElement userName = webDriver.findElement(By.id("user-name"));
        // 4. Assert Username is loggined
        softAssert.assertTrue(userName.isDisplayed());
        softAssert.assertEquals(userName.getText(), USERNAME);
        // 5. Assert there are 4 items on the header section are displayed with proper texts
        softAssert.assertTrue(webDriver.findElements(By.className("uui-navigation")).get(0).isDisplayed());
        softAssert.assertEquals(webDriver.findElements(By.className("uui-navigation")).get(0).getText(),
                "HOME\nCONTACT FORM\nSERVICE\nMETALS & COLORS");
        // 6. Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertEquals(webDriver.findElements(By.cssSelector("div.row .col-sm-3")).size(), 4);
        List<WebElement> description = webDriver.findElements(By.className("benefit-txt"));
        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        softAssert.assertEquals(description.get(0).getText(), "To include good practices\n"
                + "and ideas from successful\nEPAM project");
        softAssert.assertEquals(description.get(1).getText(), "To be flexible and\ncustomizable");
        softAssert.assertEquals(description.get(2).getText(), "To be multiplatform");
        softAssert.assertEquals(description.get(3).getText(), "Already have good base\n(about 20 internal and\n"
                + "some external projects),\nwish to get more…");
        WebElement iframe = webDriver.findElement(By.id("frame"));
        // 8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(iframe.isDisplayed());
        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame(iframe);
        softAssert.assertEquals(webDriver.findElement(By.id("frame-button")).getAttribute("value"), "Frame Button");
        // 10. Switch to original window back
        webDriver.switchTo().defaultContent();
        softAssert.assertEquals(webDriver.getWindowHandle(), pageID);
        List<WebElement> leftSideBar = webDriver.findElements(By.cssSelector("#mCSB_1_container > ul >li> a>span"));
        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        softAssert.assertEquals(leftSideBar.size(), 5);
        for (WebElement w : leftSideBar) {
            softAssert.assertTrue(w.isDisplayed());
        }
        softAssert.assertEquals(leftSideBar.get(0).getText(), "Home");
        softAssert.assertEquals(leftSideBar.get(1).getText(), "Contact form");
        softAssert.assertEquals(leftSideBar.get(2).getText(), "Service");
        softAssert.assertEquals(leftSideBar.get(3).getText(), "Metals & Colors");
        softAssert.assertEquals(leftSideBar.get(4).getText(), "Elements packs");
        // 12. Close Browser in after method
        softAssert.assertAll();

    }
}
