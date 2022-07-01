package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return all the strobogrammatic numbers that are of length n. You may return the answer in any order.
 * <p>
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 */
public class StrobogrammaticNumber {


    int target;

    public List<String> findStrobogrammatic(int n) {
        target = n;
        return find(n);
    }

    private List<String> find(int n) {

        List<String> result = new ArrayList<>();
        if (n == 0) {
            result.add("");
            return result;
        }
        if (n == 1) {
            result.add("0");
            result.add("1");
            result.add("8");

            return result;
        }

        List<String> prev = find(n - 2);

        for (String s : prev) {
            result.add("1" + s + "1");
            result.add("6" + s + "9");
            result.add("8" + s + "8");
            result.add("9" + s + "6");
            if (n < target)
                result.add("0" + s + "0");
        }

        return result;
    }
}
