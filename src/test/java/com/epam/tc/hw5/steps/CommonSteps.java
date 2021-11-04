package com.epam.tc.hw5.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonSteps extends AbstractBaseSteps {
    @Given("I open JDI GitHub site")
    public void openJdiHomePage() {
        loginPage.open(URL);
    }

    @When("I login as user \"Roman Iovlev\"")
    public void login() {
        loginPage.login(LOGIN, PASSWORD);
    }

    @Then("{string} page should be opened")
    public void checkTitle(String title) {
        assertThat(userTablePage.getSiteTitle()).isEqualTo(title);
    }
}
