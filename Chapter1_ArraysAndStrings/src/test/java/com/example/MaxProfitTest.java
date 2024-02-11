package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxProfitTest {

    private final MaxProfit maxProfit = new MaxProfit();
    @Test
    void maxProfitTest() {
        assertEquals(25, maxProfit.maxProfit(new int[] {1,23, 7, 8, 26, 17, 19, 22}));
    }
}