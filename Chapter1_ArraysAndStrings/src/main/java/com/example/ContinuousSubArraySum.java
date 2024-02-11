package com.example;


import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums and an integer k, return true if nums has a continuous subarray of size at least
 * two whose elements sum up to a multiple of k, or false otherwise.
 * <p>
 * An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 */
public class ContinuousSubArraySum {

    //O(n) time complexity and  O(k)/O(n) whichever is smaller space complexity
    public boolean checkSubarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>(); //to keep a map of modes
        map.put(0, -1); //for sub arrays starting from first index(0) which is a multiple of 7, we need this to be populated
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0)
                sum %= k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) //to make sure that the subarray size is at least two
                    return true;
            } else {
                map.put(sum, i);
            }
        }
        return false;

    }
}
