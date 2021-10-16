package com.epam.tc.hw1.sign;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw1.CalculatorBaseTest;
import org.testng.annotations.Test;


public class CalculatorPlusSignTest extends CalculatorBaseTest {
    @Test(dataProviderClass = SignDataProvider.class, dataProvider = "positiveNumberData")
    public void plusSignTest(long a, boolean expected) {

        boolean actual = calculator.isPositive(a);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProviderClass = SignDataProvider.class, dataProvider = "negativeNumberData")
    public void minusSignTest(long a, boolean expected) {

        boolean actual = calculator.isNegative(a);
        assertThat(actual).isEqualTo(expected);
    }
}
