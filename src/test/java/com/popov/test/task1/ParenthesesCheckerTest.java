package com.popov.test.task1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParenthesesCheckerTest {

    @ParameterizedTest
    @CsvSource({
            "({[]}), true",
            "(){}[], true",
            "(), true",
            "(){}[), false",
            "({[}), false",
            "(, false",
            "), false",
    })
    void isValid(String s, boolean expected) {
        ParenthesesChecker checker = new ParenthesesChecker();
        assertEquals(expected, checker.isValid(s));
    }

}
