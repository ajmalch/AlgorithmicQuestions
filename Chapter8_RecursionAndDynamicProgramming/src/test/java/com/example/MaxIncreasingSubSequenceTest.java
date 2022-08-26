package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxIncreasingSubSequenceTest {

    MaxIncreasingSubSequence maxIncreasingSubSequence = new MaxIncreasingSubSequence();

    @Test
    void maxSumIncreasingSubsequence() {

        final List<List<Integer>> result = maxIncreasingSubSequence.maxSumIncreasingSubsequence(new int[]{10, 70, 20, 30, 50, 11, 30});

        assertEquals(110, result.get(0)
                .get(0));
        assertEquals(10, result.get(1)
                .get(0));
        assertEquals(20, result.get(1)
                .get(1));
        assertEquals(30, result.get(1)
                .get(2));
        assertEquals(50, result.get(1)
                .get(3));


    }
}