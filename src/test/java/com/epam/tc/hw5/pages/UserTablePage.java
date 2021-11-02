package com.epam.tc.hw5.pages;

import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@EqualsAndHashCode(callSuper = false)
@Data
public class UserTablePage extends AbstractPage {
    @FindBy(css = "tr > td > select")
    private List<WebElement> dropDown;
    @FindBy(css = "#user-table > tbody > tr > td >a")
    private List<WebElement> users;
    @FindBy(className = "user-descr")
    private List<WebElement> userDescriptions;
    @FindBy(css = ".user-descr > input")
    private List<WebElement> checkBoxes;
    @FindBy(css = "tbody tr")
    private List<WebElement> userTable;
    @FindBy(xpath = "//tbody/tr[1]/td[2]/select/*")
    private List<WebElement> dropListForRoman;
    @FindBy(id = "ivan")
    private WebElement checkBoxSergeyIvan;
    @FindBy(css = ".info-panel-body-log .panel-body-list > li")
    private List<WebElement> logs;

    public UserTablePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Step("Get site title")
    public String getSiteTitle() {
        return webDriver.getTitle();
    }

    @Step("Count dropdowns")
    public int countDropDownNumber() {
        return dropDown.size();
    }

    @Step("Count users")
    public int countUsersNumber() {
        return users.size();
    }

    @Step("Count descriptions")
    public int countUserDescriptionNumber() {
        return userDescriptions.size();
    }

    @Step("Count checkboxes")
    public int countCheckBoxesNumber() {
        return checkBoxes.size();
    }

    @Step("Get table contents")
    public List<List<String>> getUsersOnPageAsListOfLists() {
        List<List<String>> personInfo = new ArrayList<>();
        for (WebElement row : userTable) {
            List<String> innerList = new ArrayList<>();
            String number = row.findElement(By.tagName("td")).getText();
            String userName = row.findElement(By.tagName("a")).getText();
            String description = row.findElement(By.tagName("span"))
                    .getText().replaceAll("[\\n]", " ");
            Collections.addAll(innerList, number, userName, description);
            personInfo.add(innerList);
        }
        return personInfo;
    }

    @Step("Get dropdown values for Roman")
    public List<String> dropDownValuesForRoman() {
        return dropListForRoman.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    @Step("Select 'vip' checkbox for sergey Ivan")
    public void selectCheckBoxForSergeyIvan() {
        checkBoxSergeyIvan.click();
    }

    @Step("Check logs")
    public String logsForVipCheckBox() {
        return logs.get(0).getText().substring(9);
    }

}
