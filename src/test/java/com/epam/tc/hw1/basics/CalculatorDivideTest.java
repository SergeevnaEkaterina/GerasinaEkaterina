package com.epam.tc.hw1.basics;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.epam.tc.hw1.CalculatorBaseTest;
import org.testng.annotations.Test;

public class CalculatorDivideTest extends CalculatorBaseTest {
    @Test(dataProviderClass = DivideDataProvider.class, dataProvider = "invalidLongData",
            expectedExceptions = {NumberFormatException.class})

    public void invalidLongInput(long a, long b) {
        assertThatThrownBy(() -> {
            calculator.div(a, b);
        }).isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("Attempt to divide by zero");

    }

    @Test(dataProviderClass = DivideDataProvider.class, dataProvider = "divideLongData")
    public void divideLongData(long a, long b, long expected) {
        assertThat(calculator.div(a, b)).isEqualTo(expected);

    }

    @Test(dataProviderClass = DivideDataProvider.class, dataProvider = "divideDoubleData")
    public void divideDoubleData(double a, double b, double expected) {
        assertThat(calculator.div(a, b)).isEqualTo(expected);

    }

}
