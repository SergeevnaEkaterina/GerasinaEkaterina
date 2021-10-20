package com.epam.tc.hw1.basics;

import org.testng.annotations.DataProvider;

public class MultiplyDataProvider {
    @DataProvider()
    public Object[][] multiplyLongData() {
        return new Object[][]{
                {2, 3, 6},
                {7, 7, 49}
        };
    }

    @DataProvider()
    public Object[][] multiplyDoubleData() {
        return new Object[][]{
                {2.0, 3.1, 6.0},
                {7.5, 7.3, 54.0}
        };
    }
}
