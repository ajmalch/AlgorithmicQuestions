package com.example;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class StockBuySell {

    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > result)
                result = prices[i] - minprice;

        }

        return result;
    }
}
