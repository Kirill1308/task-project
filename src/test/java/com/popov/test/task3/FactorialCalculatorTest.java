package com.popov.test.task3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorialCalculatorTest {

    @Test
    void factorialFactorialOf100ShouldReturnCorrectResult() {
        Calculator calculator = new Calculator();
        int result = calculator.calculateSumOfDigitsInFactorial(100);

        assertEquals(648, result);
    }

}
