package com.example;

/**
 * Given a string s, return the longest palindromic substring in s.
 */

public class LongestPalindromeSubstring {

    public String longestPalindromeSubstring(String s) {

        if (s == null || s.length() == 0) {
            return null;
        }

        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int len1 = expandFromMiddle(s, i, i);
            int len2 = expandFromMiddle(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > right - left + 1) {
                left = i - (len - 1) / 2;
                right = i + len / 2;
            }

        }

        return s.substring(left, right + 1);
    }

    private int expandFromMiddle(String s, int left, int right) {

        int L = left;
        int R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


}
