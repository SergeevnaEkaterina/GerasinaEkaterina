package com.epam.tc.hw5.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.data.Values;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DifferentElementsPageSteps extends AbstractBaseSteps {
    @And("I Open through the header menu Service and select Different Elements Page")
    public void openInnerPage() {
        loginPage.openDifferentElements();
    }

    @When("I select {string} in checkboxes on Different Element Page")
    public void selectWaterAndWind(String name) {
        differentElementsPage.selectCheckBoxes(name);
    }

    @And("I select radio {string}")
    public void selectSelen(String name) {
        differentElementsPage.selectRadio(name);
    }

    @And("I select {string} in dropdown")
    public void selectYellow(String name) {
        differentElementsPage.selectDropDown(name);
    }

    @Then("I expect username to be {string}")
    public void checkUser(String name) {
        assertThat(loginPage.getUserName().isDisplayed()).isTrue();
        assertThat(loginPage.getUserNameText()).isEqualTo(name);
    }

    @Then("{string} checkbox is selected")
    public void checkCheckboxes(String name) {
        assertThat(differentElementsPage.isCheckBoxSelected(name)).isTrue();
    }

    @Then("{string} radio is selected")
    public void checkRadio(String name) {
        assertThat(differentElementsPage.isRadioEnabled(name)).isTrue();
    }

    @Then("{string} is selected in dropdown")
    public void checkDropdown(String name) {
        assertThat(differentElementsPage.isDropDownSelected(name)).isTrue();
    }

    @Then("Log rows are displayed for each selected web elements containing selected items")
    public void checkLogsInformation() {
        assertThat(differentElementsPage
                .collectLogs()
                .getLogsText())
                .isEqualTo(Values.LOGS);
    }
}
