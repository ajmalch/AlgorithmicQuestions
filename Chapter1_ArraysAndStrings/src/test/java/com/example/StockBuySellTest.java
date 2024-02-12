package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockBuySellTest {

    private final StockBuySell stockBuySell = new StockBuySell();

    @Test
    void maxProfit() {

        assertEquals(23, stockBuySell.maxProfit(new int[] {48, 34, 23, 24, 27 ,46, 34, 45, 31, 41}));

    }
}