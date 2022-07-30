package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConvertNumberToWordsTest {

    ConvertNumberToWords convertNumberToWords = new ConvertNumberToWords();

    @Test
    void convertTest() {
        assertEquals("eighty one million six hundred twenty one thousand nine hundred fifty four"
                , convertNumberToWords.convert(81621954));
    }
}