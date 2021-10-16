package com.epam.tc.hw1.trigonometry;

import com.epam.tc.hw1.CalculatorBaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorCosTest extends CalculatorBaseTest {
    @Test(dataProviderClass = CosDataProvider.class, dataProvider = "cosData")
    public void cosTest(double a, double expected) {

        double actual = calculator.cos(a);
        assertEquals(actual, expected);
    }
}
