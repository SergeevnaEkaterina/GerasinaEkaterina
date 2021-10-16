package com.epam.tc.hw1.trigonometry;

import com.epam.tc.hw1.CalculatorBaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSinTest extends CalculatorBaseTest {
    @Test(dataProviderClass = SinDataProvider.class, dataProvider = "sinData")
    public void sinTest(double a, double expected) {

        double actual = calculator.sin(a);
        assertEquals(actual, expected);
    }
}
