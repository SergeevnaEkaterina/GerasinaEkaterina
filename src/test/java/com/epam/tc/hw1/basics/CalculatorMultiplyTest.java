package com.epam.tc.hw1.basics;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw1.CalculatorBaseTest;
import org.testng.annotations.Test;


public class CalculatorMultiplyTest extends CalculatorBaseTest {
    @Test(dataProviderClass = MultiplyDataProvider.class, dataProvider = "multiplyLongData")
    public void multLongTest(long a, long b, long expected) {

        long actual = calculator.mult(a, b);
        assertThat(actual).isEqualTo(expected);

    }

    @Test(dataProviderClass = MultiplyDataProvider.class, dataProvider = "multiplyDoubleData")
    public void sumDoubleTest(double a, double b, double expected) {

        double actual = calculator.mult(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
