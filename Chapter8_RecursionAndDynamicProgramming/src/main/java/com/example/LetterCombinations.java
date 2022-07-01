package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * <p>
 * A mapping of digit to letters is like on the telephone buttons. Note that 1 does not map to any letters.
 */
public class LetterCombinations {


    private Map<Character, String> digitMap = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

    private List<String> combinations = new ArrayList<>();

    private String phoneDigits;

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) {
            return combinations;
        }

        phoneDigits = digits;
        backTrack(0, new StringBuilder());

        return combinations;

    }

    private void backTrack(int index, StringBuilder path) {

        if (path.length() == phoneDigits.length()) {
            combinations.add(path.toString());
            return;
        }

        for (char c : digitMap.get(phoneDigits.charAt(index))
                .toCharArray()) {

            path.append(c);
            backTrack(index + 1, path);
            path.deleteCharAt(path.length() - 1);

        }
    }


}
