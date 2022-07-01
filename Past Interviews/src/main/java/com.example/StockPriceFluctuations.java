package com.example;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * You are given a stream of records about a particular stock.
 * Each record contains a timestamp and the corresponding price of the stock at that timestamp.
 * <p>
 * Unfortunately due to the volatile nature of the stock market, the records do not come in order.
 * Even worse, some records may be incorrect.
 * Another record with the same timestamp may appear later in the stream correcting the price of the previous wrong record.
 * <p>
 * Design an algorithm that:
 * <p>
 * Updates the price of the stock at a particular timestamp, correcting the price from any previous records at the timestamp.
 * Finds the latest price of the stock based on the current records. The latest price is the price at the latest timestamp recorded.
 * Finds the maximum price the stock has been based on the current records.
 * Finds the minimum price the stock has been based on the current records.
 * Implement the StockPrice class:
 * <p>
 * StockPrice() Initializes the object with no price records.
 * void update(int timestamp, int price) Updates the price of the stock at the given timestamp.
 * int current() Returns the latest price of the stock.
 * int maximum() Returns the maximum price of the stock.
 * int minimum() Returns the minimum price of the stock.
 */
public class StockPriceFluctuations {

    int maxTime;
    HashMap<Integer, Integer> timeToPrices;
    TreeMap<Integer, Integer> pricesToCount;

    public StockPriceFluctuations() {
        timeToPrices = new HashMap<>();
        pricesToCount = new TreeMap<>();
        maxTime = -1;
    }

    public void update(int timestamp, int price) {
        if (timeToPrices.containsKey(timestamp)) {
            int curprice = timeToPrices.get(timestamp);
            int cnt = pricesToCount.get(curprice);
            if (cnt > 1) {
                pricesToCount.put(curprice, cnt - 1);
            } else {
                pricesToCount.remove(curprice);
            }
        }

        timeToPrices.put(timestamp, price);
        pricesToCount.put(price, pricesToCount.getOrDefault(price, 0) + 1);
        maxTime = Math.max(maxTime, timestamp);
    }

    public int current() {
        return timeToPrices.get(maxTime);
    }

    public int maximum() {
        return pricesToCount.lastKey();
    }

    public int minimum() {
        return pricesToCount.firstKey();
    }


}
