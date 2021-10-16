package com.epam.tc.hw1.compound;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw1.CalculatorBaseTest;
import org.testng.annotations.Test;


public class CalculatorSqrtTest extends CalculatorBaseTest {
    @Test(dataProviderClass = SquareRootDataProvider.class, dataProvider = "sqrtData")
    public void multLongTest(double a, double expected) {

        double actual = calculator.sqrt(a);
        assertThat(actual).isEqualTo(expected);
    }
}
