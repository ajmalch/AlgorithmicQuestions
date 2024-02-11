package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubstringTest {

    LongestSubstring longestSubstring = new LongestSubstring();

    @Test
    void longestSubstringTest() {
        assertEquals(4, longestSubstring.longestSubstring("ajmal"));
        assertEquals(7, longestSubstring.longestSubstring("weryrivldsdklbdp"));
    }


    @Test
    void logestSubsringKDistinctTest(){
        assertEquals(2, longestSubstring.lengthOfLongestSubstringKDistinct("ajmal",2));
        assertEquals(3, longestSubstring.lengthOfLongestSubstringKDistinct("weryrivldsdklbdp", 2));
        assertEquals(8, longestSubstring.lengthOfLongestSubstringKDistinct("weryrivvaaallldsdklbdp", 3));
    }
}