package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckPermutationTest {

    CheckPermutation checkPermutation = new CheckPermutation();

    @Test
    void checkPermutationPositive() {
        assertTrue(checkPermutation.checkPermutation("abcdfe", "efcdab"));
    }

    @Test
    void checkPermutationSameWord() {
        assertTrue(checkPermutation.checkPermutation("ajmal", "ajmal"));
    }

    @Test
    void heckPermutationNegative() {

        assertFalse(checkPermutation.checkPermutation("gkkgkjj", "asatqq"));

    }
}