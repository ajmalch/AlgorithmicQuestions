package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    private final BubbleSort bubbleSort = new BubbleSort();
    @Test
    void bubbleSortTest() {

        int[] input = new int[] {2,45,12,345,13, 56, 734,15, 2};
        assertArrayEquals(new int [] {2,2,12,13,15,45,56,345,734}, bubbleSort.bubbleSort(input));
    }
}