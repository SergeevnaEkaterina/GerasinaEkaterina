package com.epam.tc.hw1.basics;

import org.testng.annotations.DataProvider;

public class SubtractDataProvider {
    @DataProvider()
    public Object[][] subLongData() {
        return new Object[][]{
                {2, 3, -1},
                {7, 7, 0},
                {8, 3, 5}
        };
    }

    @DataProvider()
    public Object[][] subDoubleData() {
        return new Object[][]{
                {2.0, 3.1, -1.1},
                {8.9, 7.3, 1.6000000000000005}
        };
    }
}
