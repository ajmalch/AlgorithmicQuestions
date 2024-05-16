package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCompression2Test {

    private final StringCompression2 stringCompression2 = new StringCompression2();
    @Test
    void compressedTest() {

        assertEquals("9A3A",stringCompression2.runLengthEncoding("AAAAAAAAAAAA"));
        assertEquals("1a1b3c4a2d",stringCompression2.runLengthEncoding("abcccaaaadd"));
        assertEquals("1a1j1m1a1l",stringCompression2.runLengthEncoding("ajmal"));
    }
}