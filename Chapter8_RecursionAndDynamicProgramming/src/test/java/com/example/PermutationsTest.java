package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PermutationsTest {

    Permutations permutations = new Permutations();

    /*
    1,2,3
    2,1,3
    3,2,1
    1,3,2,
    3,1,2,
    2,3,1
     */
    @Test
    void permuteTest() {

        final var permute = permutations.permute(new int[]{1, 2, 3});

        assertEquals(6, permute.size());
        assertTrue(permute.containsAll(
                List.of(List.of(1, 2, 3)
                        , List.of(2, 1, 3)
                        , List.of(3, 2, 1)
                        , List.of(1, 3, 2)
                        , List.of(3, 1, 2)
                        , List.of(2, 3, 1))));

    }
}