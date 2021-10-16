package com.epam.tc.hw1.basics;

import org.testng.annotations.DataProvider;

public class SumDataProvider {
    @DataProvider()
    public Object[][] addLongData() {
        return new Object[][] {
                {2, 3, 5},
                {7, 7, 14}
        };
    }

    @DataProvider()
    public Object[][] addDoubleData() {
        return new Object[][] {
                {2.0, 3.1, 5.1},
                {7.5, 7.3, 14.8}
        };
    }
}
