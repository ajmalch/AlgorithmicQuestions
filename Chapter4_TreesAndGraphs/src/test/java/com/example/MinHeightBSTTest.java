package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinHeightBSTTest {

    @Test
    void minHeightBstTest() {
        List<Integer> input = List.of(1, 2, 5, 7, 10, 13, 14, 15, 22);
        assertEquals(MinHeightBST.minHeightBst(input).value, 10);


    }
}