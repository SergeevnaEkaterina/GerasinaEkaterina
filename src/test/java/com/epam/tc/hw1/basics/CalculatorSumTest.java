package com.epam.tc.hw1.basics;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw1.CalculatorBaseTest;
import org.testng.annotations.Test;


public class CalculatorSumTest extends CalculatorBaseTest {
    @Test(dataProviderClass = SumDataProvider.class, dataProvider = "addLongData")
    public void sumLongTest(long a, long b, long expected) {

        long actual = calculator.sum(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProviderClass = SumDataProvider.class, dataProvider = "addDoubleData")
    public void sumDoubleTest(double a, double b, double expected) {

        double actual = calculator.sum(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
