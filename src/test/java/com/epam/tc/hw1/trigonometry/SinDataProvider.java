package com.epam.tc.hw1.trigonometry;

import org.testng.annotations.DataProvider;

public class SinDataProvider {

    @DataProvider()
    public Object[][] sinData() {
        return new Object[][]{
                {Math.PI / 6, Math.sin(Math.PI / 6)},
                {Math.PI / 3, Math.sin(Math.PI / 3)},
                {Math.PI / 4, Math.sin(Math.PI / 4)}

        };

    }
}
