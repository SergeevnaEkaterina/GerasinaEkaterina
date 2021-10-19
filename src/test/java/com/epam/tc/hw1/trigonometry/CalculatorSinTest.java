package com.epam.tc.hw1.trigonometry;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw1.CalculatorBaseTest;
import org.testng.annotations.Test;

public class CalculatorSinTest extends CalculatorBaseTest {
    @Test(dataProviderClass = SinDataProvider.class, dataProvider = "sinData")
    public void sinTest(double a, double expected) {
        double actual = calculator.sin(a);
        assertThat(actual).isEqualTo(expected);
    }
}
