package com.epam.tc.hw4.pages;

import io.qameta.allure.Step;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@EqualsAndHashCode(callSuper = false)
@Data
public class LoginPage extends AbstractPage {
    @FindBy(id = "user-icon")
    private WebElement userIcon;
    @FindBy(id = "name")
    private WebElement userLogin;
    @FindBy(id = "password")
    private WebElement userPassword;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(id = "user-name")
    private WebElement userName;
    @FindBy(linkText = "SERVICE")
    private WebElement serviceMenu;
    @FindBy(linkText = "DIFFERENT ELEMENTS")
    private WebElement differentElements;


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Step("Open login page")
    public void open(String url) {
        webDriver.navigate().to(url);
    }

    @Step("text {login} : {password}")
    public void login(String login, String password) {
        userIcon.click();
        userLogin.sendKeys(login);
        userPassword.sendKeys(password);
        loginButton.click();
    }

    @Step("Open different elements page")
    public void openDifferentElements() {
        serviceMenu.click();
        differentElements.click();
    }

    @Step("User")
    public String getUserNameText() {
        return userName.getText();
    }

    @Step("Title")
    public String getSiteTitle() {
        return webDriver.getTitle();
    }


}
