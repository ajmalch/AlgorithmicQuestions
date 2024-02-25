package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BestDigitsTest {

    private final BestDigits bestDigits = new BestDigits();

    @Test
    void bestDigitsTest() {

        assertEquals("6829", bestDigits.bestDigits("463829",2));
        assertEquals("30200004", bestDigits.bestDigits("100300200004",4));

    }
}