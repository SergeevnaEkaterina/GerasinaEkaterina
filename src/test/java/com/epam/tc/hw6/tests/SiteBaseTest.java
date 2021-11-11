package com.epam.tc.hw6.tests;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.epam.tc.hw4.data.PropertyInitialization;
import com.epam.tc.hw6.service.webdriver.WebDriverProvider;
import io.qameta.allure.Step;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SiteBaseTest {
    protected WebDriver webDriver;
    public static final String URL = PropertyInitialization.getPropertyByName("url");
    protected String pageID;

    @BeforeMethod(description = "Setup browser and maximize window")
    public void setUp(ITestContext testContext) {
        System.out.println("before method");
        webDriver = WebDriverProvider.getDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts()
                .implicitlyWait(20, TimeUnit.SECONDS);
        testContext.setAttribute("driver", webDriver);
    }

    @AfterMethod(description = "Quit browser")
    @Step("Close browser")
    public void tearDown() {
        System.out.println("after method");
        WebDriverProvider.closeDriver();
        assertThatThrownBy(webDriver::getTitle).isInstanceOf(NoSuchSessionException.class);
    }

}
