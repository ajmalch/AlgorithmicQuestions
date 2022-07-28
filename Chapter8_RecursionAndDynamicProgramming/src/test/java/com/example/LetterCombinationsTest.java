package com.example;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class LetterCombinationsTest {

    LetterCombinations letterCombinations = new LetterCombinations();

    @Test
    void letterCombinationsTest() {

        MatcherAssert.assertThat(letterCombinations.letterCombinations("24")
                , Matchers.containsInAnyOrder("ag", "ah", "ai", "bg", "bh", "bi", "cg", "ch", "ci"));

    }
}