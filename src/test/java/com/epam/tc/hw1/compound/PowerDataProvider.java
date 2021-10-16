package com.epam.tc.hw1.compound;

import org.testng.annotations.DataProvider;

public class PowerDataProvider {
    @DataProvider()
    public Object[][] powData() {
        return new Object[][]{
                {2.0, 3.0, 8.0},
                {3.0, 1.1, 3.0},
                {-3.0, 3.2, -27.0},
                {3.1, 2.2, 9.610000000000001}
        };
    }
}
