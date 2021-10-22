package com.epam.tc.hw2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class PageDifferentElementsTest extends SiteBaseTest {

    @Test
    public void innerPageDifferentElementsTest() {
        // 1. Open test site by URL
        webDriver.navigate().to(URL);
        assertThat(webDriver.getCurrentUrl()).isEqualTo("https://jdi-testing.github.io/jdi-light/index.html");
        // 2. Assert Browser title
        assertThat(webDriver.getTitle()).isEqualTo("Home Page");
        webDriver.findElements(By.className("dropdown-toggle")).get(1).click();
        WebElement username = webDriver.findElement(By.id("name"));
        WebElement password = webDriver.findElement(By.id("password"));
        // 3. Perform login
        username.sendKeys(LOGIN);
        password.sendKeys(PASSWORD);
        webDriver.findElement(By.id("login-button")).click();
        WebElement userName = webDriver.findElement(By.id("user-name"));
        // 4. Assert Username is loggined
        assertThat(userName.isDisplayed()).isTrue();
        assertThat(userName.getText()).isEqualTo(USERNAME);
        // 5. Open through the header menu Service -> Different Elements Page
        webDriver.findElement(By.linkText("SERVICE")).click();
        webDriver.findElement(By.linkText("DIFFERENT ELEMENTS")).click();
        assertThat(webDriver.getCurrentUrl()).isEqualTo("https://jdi-testing.github.io/jdi-light/different-elements.html");
        // 6. Select checkboxes
        List<WebElement> checkBoxes = webDriver.findElements(By.cssSelector(".label-checkbox>input"));
        WebElement checkWater = checkBoxes.get(0);
        WebElement checkWind = checkBoxes.get(2);
        checkWater.click();
        checkWind.click();
        assertThat(checkWater.isSelected() && checkWind.isSelected()).isTrue();
        // 7. Select radio
        WebElement radioSelen = webDriver.findElements(By.cssSelector(".checkbox-row .label-radio")).get(3);
        radioSelen.click();
        assertThat(radioSelen.isEnabled()).isTrue();
        // 8. Select in dropdown
        webDriver.findElements(By.cssSelector(".uui-form-element")).get(2).click();
        WebElement dropDownYellow = webDriver.findElements(By.cssSelector(".uui-form-element>option")).get(3);
        dropDownYellow.click();
        assertThat(dropDownYellow.isSelected()).isTrue();
        // 9. Logs check
        List<WebElement> logs = webDriver.findElements(By.cssSelector(".info-panel-body-log .panel-body-list > li"));
        assertThat(logs.get(0).getText().contains("Colors: value changed to Yellow")).isTrue();
        assertThat(logs.get(1).getText()).contains("metal: value changed to Selen");
        assertThat(logs.get(2).getText()).contains("Wind: condition changed to true");
        assertThat(logs.get(3).getText()).contains("Water: condition changed to true");
        // 10. Close browser in afterMethod
    }
}
