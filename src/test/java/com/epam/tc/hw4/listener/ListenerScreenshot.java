package com.epam.tc.hw4.listener;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerScreenshot implements ITestListener {

    @Override
    public void onTestFailure(ITestResult itestResult) {
        WebDriver driver = (WebDriver) itestResult.getTestContext().getAttribute("driver");
        attachScreenshot(driver);
    }

    @Attachment(type = "image/png", fileExtension = ".png")
    private byte[] attachScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
