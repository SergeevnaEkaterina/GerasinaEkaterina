package com.epam.tc.hw1.basics;

import org.testng.annotations.DataProvider;

public class DivideDataProvider {
    @DataProvider
    public Object[][] invalidLongData() {
        return new Object[][]{
                {4, 0},
                {3, 0},
                {5, 0}
        };
    }

    @DataProvider()
    public Object[][] divideLongData() {
        return new Object[][]{
                {2, 3, 0},
                {7, 7, 1}

        };
    }

    @DataProvider()
    public Object[][] divideDoubleData() {
        return new Object[][]{
                {2.4, 3.0, 0.7999999999999999},
                {3.0, 4.0, 0.75}

        };
    }
}
