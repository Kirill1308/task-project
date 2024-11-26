package com.popov.test.task3;

public class SumOfDigitsInFactorialTask {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int sum = calculator.calculateSumOfDigitsInFactorial(100);

        System.out.println("Sum of the digits in 100! is: " + sum);
    }

}
