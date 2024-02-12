package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCompressionTest {

    private final StringCompression stringCompression = new StringCompression();
    @Test
    void compressedTest() {

        assertEquals("a1b1c3a4d2",stringCompression.compressed("abcccaaaadd"));
        assertEquals("ajmal",stringCompression.compressed("ajmal"));
    }
}