package com.fundamentals.simplecalc;

import android.support.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

// SOS: had to add testImplementation 'org.hamcrest:hamcrest-library:1.3' for closeTo
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
@SmallTest
public class CalculatorTest {

    private Calculator mCalculator;

    // SOS: runs before each @Test is called
    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }

    @Test
    public void addTwoNumbers() {
        double resultAdd = mCalculator.add(1d, 1d);
        assertThat(resultAdd, is(equalTo(2d)));
    }

    @Test
    public void addTwoNumbersNegative() {
        double resultAdd = mCalculator.add(-1d, 2d);
        assertThat(resultAdd, is(equalTo(1d)));
    }

    @Test
    public void addTwoNumbersFloats() {
        double resultAdd = mCalculator.add(1.111f, 1.111d);
        assertThat(resultAdd, is(closeTo(2.222, 0.01)));
    }

    @Test
    public void divTwoNumbersZero() {
        double resultDiv = mCalculator.div(32d, 0);
        assertThat(resultDiv, is(equalTo(Double.POSITIVE_INFINITY)));
    }
}