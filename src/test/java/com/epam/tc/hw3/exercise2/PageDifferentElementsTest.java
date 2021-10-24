package com.epam.tc.hw3.exercise2;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw3.SiteBaseTest;
import com.epam.tc.hw3.data.LocatorsDifferentElementsPage;
import com.epam.tc.hw3.data.LocatorsIndexPage;
import com.epam.tc.hw3.data.Values;
import java.util.ArrayList;
import java.util.List;

import com.epam.tc.hw3.exercise1.IndexPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class PageDifferentElementsTest extends SiteBaseTest {

    @Test
    public void innerPageDifferentElementsTest() {
        DifferentElementsPage indexPage = PageFactory.initElements(webDriver, DifferentElementsPage.class);
        indexPage.open(URL);
        assertThat(webDriver.getCurrentUrl()).isEqualTo(URL);
        indexPage.setPageID(webDriver.getWindowHandle());
        // 2. Assert Browser title
        assertThat(indexPage.getSiteTitle()).isEqualTo(Values.TITLE);
        // 3. Perform login
        indexPage.login(LOGIN, PASSWORD);
        // 4. Assert Username is loggined
        assertThat(indexPage.getUserName().isDisplayed()).isTrue();
        assertThat(indexPage.getUserNameText()).isEqualTo(USERNAME);

//        // 1. Open test site by URL
//        webDriver.navigate().to(URL);
//        assertThat(webDriver.getCurrentUrl()).isEqualTo(URL);
//        // 2. Assert Browser title
//        assertThat(webDriver.getTitle()).isEqualTo(Values.TITLE);
//        webDriver.findElement(LocatorsIndexPage.USER_ICON).click();
//        WebElement username = webDriver.findElement(LocatorsIndexPage.NAME);
//        WebElement password = webDriver.findElement(LocatorsIndexPage.PASSWORD);
//        // 3. Perform login
//        username.sendKeys(LOGIN);
//        password.sendKeys(PASSWORD);
//        webDriver.findElement(LocatorsIndexPage.LOGIN_BUTTON).click();
//        WebElement userName = webDriver.findElement(LocatorsIndexPage.USERNAME);
//        // 4. Assert Username is loggined
//        assertThat(userName.isDisplayed()).isTrue();
//        assertThat(userName.getText()).isEqualTo(USERNAME);
        // 5. Open through the header menu Service -> Different Elements Page
        indexPage.openDifferentElements();
        assertThat(webDriver.getCurrentUrl()).isEqualTo(Values.DIFFERENT_URL);
        // 6. Select checkboxes
        List<WebElement> checkBoxes = webDriver.findElements(LocatorsDifferentElementsPage.CHECKBOXES);
        WebElement checkWater = checkBoxes.get(0);
        WebElement checkWind = checkBoxes.get(2);
        checkWater.click();
        checkWind.click();
        assertThat(checkWater.isSelected() && checkWind.isSelected()).isTrue();
        // 7. Select radio
        WebElement radioSelen = webDriver.findElements(LocatorsDifferentElementsPage.RADIO).get(3);
        radioSelen.click();
        assertThat(radioSelen.isEnabled()).isTrue();
        // 8. Select in dropdown
        webDriver.findElements(LocatorsDifferentElementsPage.DROPDOWN_LIST).get(2).click();
        WebElement dropDownYellow = webDriver.findElements(LocatorsDifferentElementsPage.DROPDOWN_ELEMENT).get(3);
        dropDownYellow.click();
        assertThat(dropDownYellow.isSelected()).isTrue();
        // 9. Logs check
        List<String> logs = new ArrayList<>();
        for (WebElement element : webDriver.findElements(LocatorsDifferentElementsPage.LOGS)) {
            logs.add(element.getText().substring(9));
        }
        assertThat(logs).isEqualTo(Values.LOGS);
        // 10. Close browser in afterMethod
    }
}
