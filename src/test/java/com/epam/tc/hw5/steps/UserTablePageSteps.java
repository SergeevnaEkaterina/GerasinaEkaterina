package com.epam.tc.hw5.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.data.Values;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.List;

public class UserTablePageSteps extends AbstractBaseSteps {

    @When("I click on \"Service\" button in Header")
    public void clickService() {
        indexPage.clickServiceButton();
    }

    @And("I click on \"User Table\" button in Service dropdown")
    public void selectUserTable() {
        indexPage.clickUserTable();
    }

    @Then("\"User Table\" page should be opened")
    public void checkTitle() {
        assertThat(userTablePage.getSiteTitle()).isEqualTo(Values.USER_PAGE_TITLE);
    }

    @And("6 Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void countDropdowns() {
        assertThat(userTablePage.countDropDownNumber()).isEqualTo(6);
    }

    @And("6 Usernames should be displayed on Users Table on User Table Page")
    public void countUsers() {
        assertThat(userTablePage.countUsersNumber()).isEqualTo(6);
    }

    @And("6 Description texts under images should be displayed on Users Table on User Table Page")
    public void countUserDescriptions() {
        assertThat(userTablePage.countUserDescriptionNumber()).isEqualTo(6);
    }

    @And("6 checkboxes should be displayed on Users Table on User Table Page")
    public void countCheckBoxes() {
        assertThat(userTablePage.countCheckBoxesNumber()).isEqualTo(6);
    }

    @And("User table should contain following values:")
    public void checkRow(DataTable dataTable) {

        List<List<String>> listFromFeatureFile = dataTable.asLists(String.class);
        List<List<String>> listWithHeaderSkipped = new ArrayList<>(listFromFeatureFile);
        listWithHeaderSkipped.remove(0);
        assertThat(userTablePage.getUsersOnPageAsListOfLists()).isEqualTo(listWithHeaderSkipped);

    }

    @And("droplist should contain values in column Type for user Roman")
    public void checkRomanDropDownOptions(DataTable dataTable) {
        List<List<String>> listFromFeatureFile = dataTable.asLists(String.class);
        List<List<String>> listWithHeaderSkipped = new ArrayList<>(listFromFeatureFile);
        listWithHeaderSkipped.remove(0);
        List<String> result = new ArrayList<>();
        listWithHeaderSkipped.forEach(result::addAll);
        assertThat(userTablePage.dropDownValuesForRoman()).isEqualTo(result);
    }

    @When("I select 'vip' checkbox for \"Sergey Ivan\"")
    public void selectCheckbox() {
        userTablePage.selectCheckBoxForSergeyIvan();
    }

    @Then("1 log row has \"Vip: condition changed to true\" text in log section")
    public void checkLog() {
        assertThat(userTablePage.logsForVipCheckBox()).isEqualTo(Values.VIP_LOG);
    }

}
