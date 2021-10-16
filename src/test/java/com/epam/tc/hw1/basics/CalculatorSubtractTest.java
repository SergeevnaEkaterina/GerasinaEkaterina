package com.epam.tc.hw1.basics;

import com.epam.tc.hw1.CalculatorBaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSubtractTest extends CalculatorBaseTest {
    @Test(dataProviderClass = SubtractDataProvider.class, dataProvider = "subLongData")
    public void subLongTest(long a, long b, long expected) {

        long actual = calculator.sub(a, b);
        assertEquals(actual, expected);
    }
    @Test(dataProviderClass = SubtractDataProvider.class, dataProvider = "subDoubleData")
    public void subDoubleTest(double a, double b, double expected) {

        double actual = calculator.sub(a, b);
        assertEquals(actual, expected);
    }
}
