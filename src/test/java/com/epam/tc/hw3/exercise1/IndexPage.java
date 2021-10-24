package com.epam.tc.hw3.exercise1;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

@Data
public class IndexPage {
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
    @CacheLookup
    @FindBy(className = "uui-navigation")
    private WebElement headerSection;
    @CacheLookup
    @FindBy(css = "div.row .col-sm-3")
    private List<WebElement> images;
    @FindBy(id = "frame")
    private WebElement iframe;
    @FindBy(id = "frame-button")
    private WebElement frameButton;
    @CacheLookup
    @FindBy(css = "#mCSB_1_container > ul >li> a>span")
    private List<WebElement> leftSideBar;

    public IndexPage(WebDriver webDriver) {
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

    public String getHeaderSectionText() {
        return headerSection.getText();
    }

    public void switchOn(boolean flag) {
        webDriver = (flag) ? this.webDriver.switchTo().frame(iframe) : this.webDriver.switchTo().defaultContent();
    }

    public String getValueOfFrameButton() {
        return frameButton.getAttribute("value");
    }

    public List<String> getDescription(List<WebElement> webElements) {
        List<String> description = new ArrayList<>();
        for (WebElement element : webElements) {
            description.add(element.getText());
        }
        return description;
    }

}
