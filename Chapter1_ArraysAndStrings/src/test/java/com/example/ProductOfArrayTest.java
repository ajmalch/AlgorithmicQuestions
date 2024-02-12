package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductOfArrayTest {

    private final ProductOfArray productOfArray = new ProductOfArray();

    @Test
    void productExceptSelfTest() {

        final int[] result = productOfArray.productExceptSelf(new int[]{5, 3, 7, 8, 2});
        final int[] expected = new int[] {3*7*8*2,5*7*8*2,5*3*8*2, 5*3*7*2, 5*3*7*8 };
        assertArrayEquals(expected, result);
    }
}