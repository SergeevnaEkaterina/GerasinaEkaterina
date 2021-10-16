package com.epam.tc.hw1.sign;

import org.testng.annotations.DataProvider;

public class SignDataProvider {
    @DataProvider()
    public Object[][] positiveNumberData() {
        return new Object[][]{
                {-2, false},
                {3, true},
                {7, true},
                {-15, false},
                {48, true},
                {150, true},
                {912, true}
        };
    }

    @DataProvider()
    public Object[][] negativeNumberData() {
        return new Object[][]{
                {-2, true},
                {3, false},
                {7, false},
                {-15, true},
                {48, false},
                {-896, true},
                {-912, true}
        };
    }
}
