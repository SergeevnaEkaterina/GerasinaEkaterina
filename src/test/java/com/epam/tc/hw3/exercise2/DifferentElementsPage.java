package com.epam.tc.hw3.exercise2;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Data
public class DifferentElementsPage {
    public WebDriver webDriver;
    private String pageID;
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
    @FindBy(css = ".label-checkbox > input")
    private List<WebElement> checkBoxes;
    @FindBy(css = ".checkbox-row .label-radio")
    private WebElement radio;
    @FindBy(css = ".uui-form-element")
    private WebElement dropdown_list;
    @FindBy(css = ".uui-form-element > option")
    private WebElement dropdown_element;
    @FindBy(css = ".info-panel-body-log .panel-body-list > li")
    private List<WebElement> logs;

    public DifferentElementsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void open(String url) {
        webDriver.navigate().to(url);
    }

    public String getSiteTitle() {
        return webDriver.getTitle();
    }

    public void login(String login, String password) {
        userIcon.click();
        userLogin.sendKeys(login);
        userPassword.sendKeys(password);
        loginButton.click();
    }

    public String getUserNameText() {
        return userName.getText();
    }

    public void openDifferentElements() {
        serviceMenu.click();
        differentElements.click();
    }
    public void selectCheckBoxes(){

    }
}
