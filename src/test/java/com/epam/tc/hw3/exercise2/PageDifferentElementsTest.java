package com.epam.tc.hw3.exercise2;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw3.SiteBaseTest;
import com.epam.tc.hw3.data.Values;
import com.epam.tc.hw3.pages.DifferentElementsPage;
import com.epam.tc.hw3.pages.LoginPage;
import org.testng.annotations.Test;

public class PageDifferentElementsTest extends SiteBaseTest {

    @Test
    public void innerPageDifferentElementsTest() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.open(URL);
        assertThat(webDriver.getCurrentUrl()).isEqualTo(URL);
        pageID = webDriver.getWindowHandle();
        // 2. Assert Browser title
        assertThat(webDriver.getTitle()).isEqualTo(Values.TITLE);
        // 3. Perform login
        loginPage.login(LOGIN, PASSWORD);
        // 4. Assert Username is loggined
        assertThat(loginPage.getUserName().isDisplayed()).isTrue();
        assertThat(loginPage.getUserNameText()).isEqualTo(USERNAME);
        // 5. Open through the header menu Service -> Different Elements Page
        loginPage.openDifferentElements();
        DifferentElementsPage differentPage = new DifferentElementsPage(webDriver);
        assertThat(webDriver.getCurrentUrl()).isEqualTo(Values.DIFFERENT_URL);
        // 6. Select checkboxes
        differentPage.selectCheckBoxes(0).selectCheckBoxes(2);
        assertThat(differentPage.getCheckBoxes().get(0).isSelected()
                && differentPage.getCheckBoxes().get(2).isSelected()).isTrue();
        // 7. Select radio
        differentPage.selectRadio(3);
        assertThat(differentPage.getRadio().get(3).isEnabled()).isTrue();
        // 8. Select in dropdown
        differentPage.selectDropDown(2, 3);
        assertThat(differentPage.getDropdown_element().get(3).isSelected()).isTrue();
        // 9. Logs check
        differentPage.collectLogs();
        assertThat(differentPage.getLogsText()).isEqualTo(Values.LOGS);
        // 10. Close browser in afterMethod
    }
}
