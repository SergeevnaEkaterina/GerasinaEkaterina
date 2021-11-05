package com.epam.tc.hw5.steps;

import static org.assertj.core.api.Assertions.assertThat;

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

    @And("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void countDropdowns(int count) {
        assertThat(userTablePage.countDropDownNumber()).isEqualTo(count);
    }

    @And("{int} Usernames should be displayed on Users Table on User Table Page")
    public void countUsers(int count) {
        assertThat(userTablePage.countUsersNumber()).isEqualTo(count);
    }

    @And("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void countUserDescriptions(int count) {
        assertThat(userTablePage.countUserDescriptionNumber()).isEqualTo(count);
    }

    @And("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void countCheckBoxes(int count) {
        assertThat(userTablePage.countCheckBoxesNumber()).isEqualTo(count);
    }

    @And("User table should contain following values:")
    public void checkRow(DataTable dataTable) {
        List<List<String>> listFromFeatureFile = dataTable.asLists(String.class);
        List<List<String>> listWithHeaderSkipped = new ArrayList<>(listFromFeatureFile);
        listWithHeaderSkipped.remove(0);
        assertThat(userTablePage.getUsersOnPageAsListOfLists()).isEqualTo(listWithHeaderSkipped);
    }

    @And("Droplist should contain values in column Type for user Roman")
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

    @Then("1 log row has {string} text in log section")
    public void checkLog(String logText) {
        assertThat(userTablePage.logsForVipCheckBox()).isEqualTo(logText);
    }

}
