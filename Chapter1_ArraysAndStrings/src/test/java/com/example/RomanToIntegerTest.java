package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanToIntegerTest {

    private final RomanToInteger romanToInteger = new RomanToInteger();
    @Test
    void romanToIntTest() {

        assertEquals(948, romanToInteger.romanToInt("CMXLVIII"));

    }
}