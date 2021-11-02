package com.epam.tc.hw5.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw4.data.Values;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DifferentElementsPageSteps extends AbstractBaseSteps {
    @And("I Open through the header menu Service and select Different Elements Page")
    public void openInnerPage() {
        loginPage.openDifferentElements();
    }

    @When("I select 'Water' and 'Wind' in checkboxes on Different Element Page")
    public void selectWaterAndWind() {
        differentElementsPage.selectCheckBoxes(0)
                .selectCheckBoxes(2);
    }

    @And("I select radio 'Selen'")
    public void selectSelen() {
        differentElementsPage.selectRadio(3);
    }

    @And("I select 'Yellow' in dropdown")
    public void selectYellow() {
        differentElementsPage.selectDropDown(2, 3);
    }

    @Then("I expect username to be 'ROMAN IOVLEV'")
    public void checkUser() {
        assertThat(loginPage.getUserName().isDisplayed()).isTrue();
        assertThat(loginPage.getUserNameText()).isEqualTo(USERNAME);
    }

    @Then("'Water' and 'Wind' checkboxes are selected")
    public void checkCheckboxes() {
        assertThat(differentElementsPage.isCheckBoxSelected(0)
                && differentElementsPage.isCheckBoxSelected(2)).isTrue();
    }

    @Then("'Selen' radio is selected")
    public void checkRadio() {
        assertThat(differentElementsPage.isRadioEnabled(3)).isTrue();
    }

    @Then("'Yellow' is selected in dropdown")
    public void checkDropdown() {
        assertThat(differentElementsPage.isDropDownSelected(3)).isTrue();
    }

    @Then("Log rows are displayed for each selected web elements containing selected items")
    public void checkLogsInformation() {
        assertThat(differentElementsPage
                .collectLogs()
                .getLogsText())
                .isEqualTo(Values.LOGS);
    }
}
