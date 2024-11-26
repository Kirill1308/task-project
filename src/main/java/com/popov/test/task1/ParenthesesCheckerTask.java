package com.popov.test.task1;

public class ParenthesesCheckerTask {
    public static void main(String[] args) {
        ParenthesesChecker checker = new ParenthesesChecker();
        System.out.println(checker.isValid("({[]})")); // true
        System.out.println(checker.isValid("({[})")); // false
    }
}
