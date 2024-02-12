package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NextPermutationTest {

    private final NextPermutation nextPermutation = new NextPermutation();

    @Test
    void nextPermutation() {
        int[] array = new int[] {2,8, 9,7,8,1,7,4,3,2,};
        int[] expected = new int[] {2,8,9,7,8,2,1,3,4,7};

        nextPermutation.nextPermutation(array);
        assertArrayEquals(expected, array);

    }
}