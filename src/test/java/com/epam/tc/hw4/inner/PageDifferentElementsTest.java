package com.epam.tc.hw4.inner;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw4.SiteBaseTest;
import com.epam.tc.hw4.data.LoginDataProvider;
import com.epam.tc.hw4.data.Values;
import com.epam.tc.hw4.listener.ListenerScreenshot;
import com.epam.tc.hw4.pages.DifferentElementsPage;
import com.epam.tc.hw4.pages.LoginPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Feature("Inner page \"Different elements\" functionality")
@Story("Selecting checkboxes, ratio, dropdown")

public class PageDifferentElementsTest extends SiteBaseTest {

    @Test(dataProviderClass = LoginDataProvider.class, dataProvider = "userRomanData")
    public void innerPageDifferentElementsTest(String login, String password, String username) {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.open(URL);
        assertThat(webDriver.getCurrentUrl()).isEqualTo(URL);
        pageID = webDriver.getWindowHandle();
        // 2. Assert Browser title
        assertThat(webDriver.getTitle()).isEqualTo(Values.TITLE);
        // 3. Perform login
        loginPage.login(login, password);
        // 4. Assert Username is loggined
        assertThat(loginPage.getUserName().isDisplayed()).isTrue();
        assertThat(loginPage.getUserNameText()).isEqualTo(username);
        // 5. Open through the header menu Service -> Different Elements Page
        loginPage.openDifferentElements();
        DifferentElementsPage differentPage = new DifferentElementsPage(webDriver);
        assertThat(webDriver.getCurrentUrl()).isEqualTo(Values.DIFFERENT_URL);
        // 6. Select checkboxes
        differentPage
                .selectCheckBoxes(0)
                .selectCheckBoxes(2);
        assertThat(differentPage.isCheckBoxSelected(0)
                && differentPage.isCheckBoxSelected(2)).isTrue();
        // 7. Select radio
        assertThat(differentPage
                .selectRadio(3)
                .isRadioEnabled(3))
                .isTrue();
        // 8. Select in dropdown
        assertThat(differentPage.selectDropDown(2, 3)
                .isDropDownSelected(3))
                .isTrue();
        // 9. Logs check
        assertThat(differentPage
                .collectLogs()
                .getLogsText())
                .isEqualTo(Values.LOGS);
        // 10. Close browser in afterMethod
    }
}
