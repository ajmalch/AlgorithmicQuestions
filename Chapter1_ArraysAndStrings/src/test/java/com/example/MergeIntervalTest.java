package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeIntervalTest {

    private final  MergeInterval mergeInterval = new MergeInterval();

    @Test
    void mergeTest() {

        int[][] inputintervals = new int[][] {
                {4, 8},
                {4, 10},
                {6, 8},
                {13, 17},
                {22, 25},
                {1, 3}

        };

        int[][] expectedResult = new int [][] {
                {1,3},
                {4,10},
                {13,17},
                {22, 25}
        };
        final int[][] actualOutput = mergeInterval.merge(inputintervals);

        assertArrayEquals(expectedResult, actualOutput);

    }
}