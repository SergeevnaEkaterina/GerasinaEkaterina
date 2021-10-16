package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class CalculatorBaseTest {
    protected Calculator calculator;

    @BeforeMethod
    public void setUp() {
        System.out.println("before method");
        calculator = new Calculator();
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("after method");
        System.out.println();
        calculator = null;
    }
}
