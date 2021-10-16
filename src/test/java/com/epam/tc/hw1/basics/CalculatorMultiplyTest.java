package com.epam.tc.hw1.basics;

import com.epam.tc.hw1.CalculatorBaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorMultiplyTest extends CalculatorBaseTest {
    @Test(dataProviderClass = MultiplyDataProvider.class, dataProvider = "multiplyLongData")
    public void multLongTest(long a, long b, long expected) {

        long actual = calculator.mult(a, b);
        assertEquals(actual, expected);
    }
    @Test(dataProviderClass = MultiplyDataProvider.class, dataProvider = "multiplyDoubleData")
    public void sumDoubleTest(double a, double b, double expected) {

        double actual = calculator.mult(a, b);
        assertEquals(actual, expected);
    }
}
