package com.example;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
 * it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * <p>
 */

public class ValidPalindrome {

    /**
     * Given a string s, return true if it is a palindrome, or false otherwise.
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;
        }

        return true;
    }


    /**
     * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
     *
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {

        int length = s.length();
        int leftIndex = 0;
        int rightIndex = length - 1;
        boolean foundDifference = false;

        while (leftIndex < rightIndex) {

            if (s.charAt(leftIndex) != s.charAt(rightIndex)) {
                if (foundDifference) {
                    return false;
                } else {
                    foundDifference = true;
                    if (s.charAt(leftIndex) == s.charAt(rightIndex - 1)) {
                        rightIndex--;
                    } else if (s.charAt(leftIndex + 1) == s.charAt(rightIndex)) {
                        leftIndex++;
                    } else {
                        return false;
                    }
                }

            } else {
                leftIndex++;
                rightIndex--;
            }

        }

        return true;

    }

}
