package com.epam.tc.hw1.compound;

import org.testng.annotations.DataProvider;

public class SquareRootDataProvider {
    @DataProvider()
    public Object[][] sqrtData() {
        return new Object[][]{
                {4.0, 2.0},
                {5.0, 2.23606797749979},
                {9.0, 3.0},
                {1.44, 1.2}
        };
    }
}
