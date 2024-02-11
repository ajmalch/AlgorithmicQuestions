package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumWindowSubStringTest {

    private final MinimumWindowSubString minimumWindowSubString = new MinimumWindowSubString();
    @Test
    void minWindow() {

        assertEquals("BANC",minimumWindowSubString.minWindow("ADOBECODEBANC","ABC" ));

    }
}