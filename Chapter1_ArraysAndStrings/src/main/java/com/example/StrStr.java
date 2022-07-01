package com.example;

/**
 * Implement strStr().
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Clarification:
 * <p>
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * <p>
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */
public class StrStr {

    public int strStr(String haystack, String needle) {
        int hslength = haystack.length();
        int needleLength = needle.length();

        if (needleLength == 0)
            return 0;

        int left = 0;
        int right = needleLength - 1;
        while (right < hslength) {
            int index = 0;
            while (index < needleLength) {
                if (haystack.charAt(left + index) != needle.charAt(index))
                    break;
                if (index == needleLength - 1)
                    return left;
                index++;
            }
            left++;
            right++;
        }
        return -1;
    }
}
