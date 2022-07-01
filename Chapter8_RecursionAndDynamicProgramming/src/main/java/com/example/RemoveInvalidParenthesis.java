package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.
 * <p>
 * Return all the possible results. You may return the answer in any order.
 */
public class RemoveInvalidParenthesis {


    Set<String> validExpressions = new HashSet<>();
    int minimumRemoved = Integer.MAX_VALUE;

    public List<String> removeInvalidParentheses(String s) {

        recurse(s, 0, 0, 0, new StringBuilder(), 0);
        return new ArrayList(validExpressions);
    }

    private void recurse(String s,
                         int index,
                         int leftCount,
                         int rightCount,
                         StringBuilder expression,
                         int removedCount) {

        if (index == s.length()) {

            if (leftCount == rightCount) {

                if (removedCount <= minimumRemoved) {
                    if (removedCount < minimumRemoved) {
                        minimumRemoved = removedCount;
                        validExpressions.clear();
                    }
                    validExpressions.add(expression.toString());
                }
            }
        } else {

            char currentCharacter = s.charAt(index);
            int length = expression.length();

            if (currentCharacter != '(' && currentCharacter != ')') {
                expression.append(currentCharacter);
                recurse(s, index + 1, leftCount, rightCount, expression, removedCount);
                expression.deleteCharAt(length);
            } else {

                if (removedCount <= minimumRemoved) {
                    recurse(s, index + 1, leftCount, rightCount, expression, removedCount + 1);
                }

                expression.append(currentCharacter);
                if (currentCharacter == '(') {
                    recurse(s, index + 1, leftCount + 1, rightCount, expression, removedCount);
                } else if (leftCount > rightCount) {
                    recurse(s, index + 1, leftCount, rightCount + 1, expression, removedCount);
                }
                expression.deleteCharAt(length);
            }


        }

    }

}
