package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */

public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        backTrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backTrack(List<String> result, StringBuilder curr, int open, int close, int max) {

        if (curr.length() == 2 * max) {
            result.add(curr.toString());
            return;
        }

        if (open < max) {
            curr.append("(");
            backTrack(result, curr, open + 1, close, max);
            curr.deleteCharAt(curr.length() - 1);
        }
        if (close < open) {
            curr.append(")");
            backTrack(result, curr, open, close + 1, max);
            curr.deleteCharAt(curr.length() - 1);
        }

    }
}
