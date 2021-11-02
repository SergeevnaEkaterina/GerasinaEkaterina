package com.epam.tc.hw5.pages;

import io.qameta.allure.Step;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@EqualsAndHashCode(callSuper = false)
@Data
public class IndexPage extends AbstractPage {

    @FindBy(className = "dropdown-toggle")
    private List<WebElement> serviceDropdown;
    @FindBy(css = ".dropdown-menu > li >a")
    private List<WebElement> userTable;

    public IndexPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Step("Click Service dropdown")
    public void clickServiceButton() {
        serviceDropdown.get(0).click();
    }

    @Step("Select User Table")
    public void clickUserTable() {
        userTable.get(5).click();
    }

}
