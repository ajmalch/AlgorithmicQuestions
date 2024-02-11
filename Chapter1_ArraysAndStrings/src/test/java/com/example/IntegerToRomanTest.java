package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntegerToRomanTest {

    private final IntegerToRoman integerToRoman = new IntegerToRoman();
    @Test
    void intToRomanTest() {

        assertEquals("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMDLXXVI"
                , integerToRoman.intToRoman(98576));
    }
}