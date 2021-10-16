package com.epam.tc.hw1.trigonometry;

import org.testng.annotations.DataProvider;

public class CosDataProvider {
    @DataProvider()
    public Object[][] cosData() {
        return new Object[][]{
                {Math.PI/6, Math.cos(Math.PI/6)},
                {Math.PI/3, Math.cos(Math.PI/3)},
                {Math.PI/4, Math.cos(Math.PI/4)}

        };

    }
}
