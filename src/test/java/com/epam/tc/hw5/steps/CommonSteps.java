package com.epam.tc.hw5.steps;

import io.cucumber.java.en.Given;
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

}
