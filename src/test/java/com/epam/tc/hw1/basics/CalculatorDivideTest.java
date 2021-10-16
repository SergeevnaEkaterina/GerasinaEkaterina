package com.epam.tc.hw1.basics;

import com.epam.tc.hw1.CalculatorBaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class CalculatorDivideTest extends CalculatorBaseTest {
    @Test(dataProviderClass = DivideDataProvider.class, dataProvider = "invalidLongData", expectedExceptions = {NumberFormatException.class})
    public void invalidLongInput(long a, long b) {
        assertEquals(calculator.div(a, b), a / b);

    }

    @Test(dataProviderClass = DivideDataProvider.class, dataProvider = "divideLongData")
    public void divideLongData(long a, long b, long expected) {
        assertEquals(calculator.div(a, b), expected);
    }

    @Test(dataProviderClass = DivideDataProvider.class, dataProvider = "divideDoubleData")
    public void divideDoubleData(double a, double b, double expected) {
        assertEquals(calculator.div(a, b), expected);

    }

}
