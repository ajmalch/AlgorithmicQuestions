package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreeLargestTest {

    private final ThreeLargest threeLargest = new ThreeLargest();
    @Test
    void findThreeLargestNumbersTest() {
        int[] array = new int [] {141,1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
        int[] result = threeLargest.findThreeLargetsNumbers(array);

        assertEquals(18, result[0]);
        assertEquals(141, result[1]);
        assertEquals(541, result[2]);
    }
}