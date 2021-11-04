package com.epam.tc.hw5;

import com.epam.tc.hw5.listener.ListenerScreenshot;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;

@Listeners(ListenerScreenshot.class)
@CucumberOptions(plugin = {"pretty"})
public class RunAcceptanceTest extends AbstractTestNGCucumberTests {
}
