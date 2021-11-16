package com.epam.tc.hw7.test;

import static com.epam.tc.hw7.pages.JdiSite.metalsAndColorsPage;
import static com.epam.tc.hw7.pages.JdiSite.selectMenu;
import static com.epam.tc.hw7.pages.MetalsAndColorsPage.listLogs;
import static com.epam.tc.hw7.pages.MetalsAndColorsPage.metalsAndColorsForm;
import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw7.data.ExpectedJsonInfo;
import com.epam.tc.hw7.data.InfoDataProvider;
import com.epam.tc.hw7.model.MetalsAndColors;
import org.testng.annotations.Test;

public class JdiSiteTest extends JdiBaseTest {

    @Test(dataProvider = "jsonData", dataProviderClass = InfoDataProvider.class)
    public void metalsAndColorsTest(MetalsAndColors metalsAndColors) {
        selectMenu(HEADER_MENU);
        metalsAndColorsPage.checkOpened();
        metalsAndColorsForm.fillForm(metalsAndColors);
        assertThat(listLogs())
                .isEqualTo(ExpectedJsonInfo.formJsonInfoToList(metalsAndColors));
    }
}
