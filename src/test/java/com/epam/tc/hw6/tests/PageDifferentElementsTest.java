package com.epam.tc.hw6.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw6.data.LoginDataProvider;
import com.epam.tc.hw6.data.Values;
import com.epam.tc.hw6.listener.ListenerScreenshot;
import com.epam.tc.hw6.steps.SiteInnerPageSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Feature("Inner page \"Different elements\" functionality")
@Story("Selecting checkboxes, ratio, dropdown")
@Listeners(ListenerScreenshot.class)
public class PageDifferentElementsTest extends SiteBaseTest {

    @Test(dataProviderClass = LoginDataProvider.class, dataProvider = "userRomanData")
    public void innerPageDifferentElementsTest(String login, String password, String username) {
        SiteInnerPageSteps siteInnerPageSteps = new SiteInnerPageSteps(webDriver);
        siteInnerPageSteps.openByUrl(URL);
        assertThat(webDriver.getCurrentUrl()).isEqualTo(URL);
        pageID = webDriver.getWindowHandle();
        // 2. Assert Browser title
        siteInnerPageSteps.assertTitle();
        // 3. Perform login
        siteInnerPageSteps.performLogin(login, password);
        // 4. Assert Username is loggined
        siteInnerPageSteps.assertUserName(username);
        // 5. Open through the header menu Service -> Different Elements Page
        siteInnerPageSteps.openInnerPage();
        assertThat(webDriver.getCurrentUrl()).isEqualTo(Values.DIFFERENT_URL);
        // 6. Select checkboxes
        siteInnerPageSteps.selectCheckBoxes();
        // 7. Select radio
        siteInnerPageSteps.selectRadio();
        // 8. Select in dropdown
        siteInnerPageSteps.selectInDropDown();
        // 9. Logs check
        siteInnerPageSteps.logsCheck();
        // 10. Close browser in afterMethod
    }
}
