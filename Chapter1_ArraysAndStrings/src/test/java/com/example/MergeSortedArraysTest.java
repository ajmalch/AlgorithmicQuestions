package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortedArraysTest {

    private final MergeSortedArrays mergeSortedArrays = new MergeSortedArrays();

    @Test
    void mergeTest() {
        int[] array1 = new int[] {1,4, 7, 8,15, 34, 0,0,0,0,0};
        int[] array2 = new int[] {2, 4, 7, 45, 64};

        mergeSortedArrays.merge(array1,6, array2,5);

        int[] mergeExpected = new int[] {1,2,4,4,7,7,8,15,34,45,64};

        assertArrayEquals(mergeExpected, array1);

    }
}