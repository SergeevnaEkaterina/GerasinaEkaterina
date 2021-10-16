package com.epam.tc.hw1.compound;

import com.epam.tc.hw1.CalculatorBaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorPowTest extends CalculatorBaseTest {
    @Test(dataProviderClass = PowerDataProvider.class, dataProvider = "powData")
    public void powTest(double a, double b, double expected) {

        double actual = calculator.pow(a, b);
        assertEquals(actual, expected);
    }
}
