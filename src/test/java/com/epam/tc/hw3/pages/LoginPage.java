package com.epam.tc.hw3.pages;

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

    public void open(String url) {
        webDriver.navigate().to(url);
    }

    public void login(String login, String password) {
        userIcon.click();
        userLogin.sendKeys(login);
        userPassword.sendKeys(password);
        loginButton.click();
    }

    public void openDifferentElements() {
        serviceMenu.click();
        differentElements.click();

    }

    public String getUserNameText() {
        return userName.getText();
    }

    public String getSiteTitle() {
        return webDriver.getTitle();
    }


}
