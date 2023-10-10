package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubstringTest {

    LongestSubstring longestSubstring = new LongestSubstring();

    @Test
    void longestSubstringTest() {
        assertEquals(4, longestSubstring.longestSubstring("ajmal"));
    }


}