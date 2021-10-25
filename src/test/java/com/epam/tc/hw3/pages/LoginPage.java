package com.epam.tc.hw3.pages;

import com.epam.tc.hw3.data.LocatorsLoginPage;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class LoginPage extends AbstractPage {
    @FindBy(id = LocatorsLoginPage.USER_ICON)
    private WebElement userIcon;
    @FindBy(id = LocatorsLoginPage.NAME)
    private WebElement userLogin;
    @FindBy(id = LocatorsLoginPage.PASSWORD)
    private WebElement userPassword;
    @FindBy(id = LocatorsLoginPage.LOGIN_BUTTON)
    private WebElement loginButton;
    @FindBy(id = LocatorsLoginPage.USERNAME)
    private WebElement userName;
    @FindBy(linkText = LocatorsLoginPage.SERVICE_MENU)
    private WebElement serviceMenu;
    @FindBy(linkText = LocatorsLoginPage.DIFFERENT_ELEMENTS)
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
