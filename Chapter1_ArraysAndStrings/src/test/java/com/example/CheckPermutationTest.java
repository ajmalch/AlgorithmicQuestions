package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CheckPermutationTest {

    CheckPermutation checkPermutation = new CheckPermutation();

    @Test
    void checkPermutationPositive() {

        assertTrue(checkPermutation.checkPermutation("abcdfe", "efcdab"));
        assertTrue(checkPermutation.checkPermutation2("abcdfe", "efcdab"));
    }

    @Test
    void checkPermutationSameWord() {

        assertTrue(checkPermutation.checkPermutation("ajmal", "ajmal"));
        assertTrue(checkPermutation.checkPermutation2("ajmal", "ajmal"));
    }

    @Test
    void checkPermutationNegative() {

        assertFalse(checkPermutation.checkPermutation("gkkgkjj", "asatqq"));
        assertFalse(checkPermutation.checkPermutation2("gkkgkjj", "asatqq"));

    }
}