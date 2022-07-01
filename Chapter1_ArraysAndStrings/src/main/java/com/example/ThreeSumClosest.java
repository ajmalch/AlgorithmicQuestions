package com.example;

import java.util.Arrays;

/**
 * Given an integer array nums of length n and an integer target,
 * find three integers in nums such that the sum is closest to target.
 * <p>
 * Return the sum of the three integers.
 * <p>
 * You may assume that each input would have exactly one solution.
 */

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {

                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                        while (right >= 0 && nums[right] == nums[right + 1])
                            right--;
                    } else {
                        left++;
                        while (left < nums.length && nums[left] == nums[left - 1])
                            left++;
                    }
                    if (Math.abs(target - result) > Math.abs(target - sum)) {
                        result = sum;
                    }
                }
            }
        }

        return result;

    }
}
