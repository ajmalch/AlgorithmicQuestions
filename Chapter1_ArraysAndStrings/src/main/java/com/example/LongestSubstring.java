package com.example;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 */

public class LongestSubstring {


    public int longestSubstring(String s) {

        if (s == null) {
            return 0;
        }
        int length = s.length();
        if (length == 0) {
            return 0;
        }

        Map<Character, Integer> rightmostIndex = new HashMap<>();
        int left = 0;
        int right = 0;

        int maxLength = 1;
        while (right < length) {

            if (rightmostIndex.containsKey(s.charAt(right))) {
                left = rightmostIndex.get(s.charAt(right)) + 1;
                rightmostIndex.put(s.charAt(right), right);
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;

    }


    /**
     * Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.
     *
     * @param s
     * @param k
     * @return length of the longest substring of s that contains at most k distinct characters
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        int n = s.length();
        if (n * k == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new LinkedHashMap<>();

        int maxLength = 1;

        while (right < n) {
            Character c = s.charAt(right);
            if (map.containsKey(c)) {
                map.remove(c);
            }
            map.put(c, right++);

            if (map.size() == k + 1) {
                Map.Entry<Character, Integer> firstElement = map.entrySet()
                        .iterator()
                        .next();
                map.remove(firstElement.getKey());
                left = firstElement.getValue() + 1;
            }

            maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;
    }

}
