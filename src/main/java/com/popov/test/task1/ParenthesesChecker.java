package com.popov.test.task1;

import java.util.List;
import java.util.Stack;

/*
 Task: check if the string contains valid parentheses (open and close)
 Example: "({[]})" - valid, "({[})" - invalid

 I will use the stack to solve this task
 I will iterate through the string and push open parentheses to the stack
 When I encounter a close parentheses I will pop the last element from the stack
 and check if it is the corresponding open parentheses
 If it is not, the string is invalid
 If the stack is empty at the end of the iteration, the string is valid
*/

public class ParenthesesChecker {

    private static final List<Character> OPEN_PARENTHESIS = List.of('(', '[', '{');

    public boolean isValid(String s) {
        if (s == null ||
            s.isEmpty() ||
            s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (OPEN_PARENTHESIS.contains(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char last = stack.pop();
                if (c == ')' && last != '(' || c == ']' && last != '[' || c == '}' && last != '{') {
                    return false;
                }
            }
        }

        return true;
    }

}
