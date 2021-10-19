package com.epam.tc.hw1.compound;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw1.CalculatorBaseTest;
import org.testng.annotations.Test;

public class CalculatorPowTest extends CalculatorBaseTest {
    @Test(dataProviderClass = PowerDataProvider.class, dataProvider = "powData")
    public void powTest(double a, double b, double expected) {
        double actual = calculator.pow(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
