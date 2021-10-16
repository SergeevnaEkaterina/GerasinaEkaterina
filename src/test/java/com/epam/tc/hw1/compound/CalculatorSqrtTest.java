package com.epam.tc.hw1.compound;

import com.epam.tc.hw1.CalculatorBaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSqrtTest extends CalculatorBaseTest {
    @Test(dataProviderClass = SquareRootDataProvider.class, dataProvider = "sqrtData")
    public void multLongTest(double a, double expected) {

        double actual = calculator.sqrt(a);
        assertEquals(actual, expected);
    }
}
