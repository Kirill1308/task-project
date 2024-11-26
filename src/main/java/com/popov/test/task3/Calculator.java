package com.popov.test.task3;

import java.math.BigInteger;

public class Calculator {

    // I am using BigInteger to calculate the factorial of a number
    // because the result can be very large and exceed the limits of long or int.

    public int calculateSumOfDigitsInFactorial(int n) {
        BigInteger fact = factorial(n);
        String factStr = fact.toString();
        int sum = 0;
        for (char digit : factStr.toCharArray()) {
            sum += digit - '0'; // Convert char to int
        }
        return sum;
    }

    private BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

}
