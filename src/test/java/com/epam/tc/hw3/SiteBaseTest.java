package com.epam.tc.hw3;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.epam.tc.hw3.data.PropertyInitialization;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SiteBaseTest {
    protected WebDriver webDriver;
    public static final String URL = PropertyInitialization.getPropertyByName("url");
    protected String pageID;

    @BeforeMethod
    public void setUp() {
        System.out.println("before method");
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("after method");
        webDriver.quit();
        assertThatThrownBy(webDriver::getTitle).isInstanceOf(NoSuchSessionException.class);
    }
}
