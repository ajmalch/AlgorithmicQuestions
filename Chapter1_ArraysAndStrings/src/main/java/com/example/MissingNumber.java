package com.example;

/**
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;

        return (nums.length * (nums.length + 1) / 2) - sum;

    }
}
