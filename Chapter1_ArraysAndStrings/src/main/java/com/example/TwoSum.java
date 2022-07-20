package com.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 */
public class TwoSum {


    //Time complexity O(n) space complexity O(n)

    /**
     * O(n) Time complexity and O(n) space complexity
     *
     * @param nums   input array
     * @param target target sum
     * @return indices of two numbers adding upto target sum
     */

    public int[] twoSum(int[] nums, int target) {

        //map to store index as value for comapring against target;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(target - nums[i]))
                return new int[]{i, map.get(target - nums[i])};
            map.put(nums[i], i);

        }

        return null;
    }
}
