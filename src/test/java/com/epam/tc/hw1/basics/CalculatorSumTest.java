package com.epam.tc.hw1.basics;

import com.epam.tc.hw1.CalculatorBaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSumTest extends CalculatorBaseTest {
    @Test(dataProviderClass = SumDataProvider.class, dataProvider = "addLongData")
    public void sumLongTest(long a, long b, long expected) {
        System.out.printf("add %d * %d data provider test%n", a, b);
        long actual = calculator.sum(a, b);
        assertEquals(actual, expected);
    }
    @Test(dataProviderClass = SumDataProvider.class, dataProvider = "addDoubleData")
    public void sumDoubleTest(double a, double b, double expected) {

        double actual = calculator.sum(a, b);
        assertEquals(actual, expected);
    }
}
