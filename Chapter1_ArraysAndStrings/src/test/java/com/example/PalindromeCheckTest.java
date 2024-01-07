package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeCheckTest {

    private final PalindromeCheck palindromeCheck = new PalindromeCheck();

    @Test
    void checkPalindromeTest() {
        assertTrue(palindromeCheck.checkPalindrom("abcdcba"));
    }
}