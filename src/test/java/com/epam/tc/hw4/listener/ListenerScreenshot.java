package com.epam.tc.hw4.listener;

import com.epam.tc.hw4.utils.AttachmentUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListenerScreenshot implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        Object driver = result.getTestContext().getAttribute("driver");
        if (driver != null) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            AttachmentUtils.makeScreenShotAttachment("Screenshot of failure", screenshot);
        }
    }
}