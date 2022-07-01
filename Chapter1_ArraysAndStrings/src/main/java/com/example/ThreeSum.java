package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets
 * [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {


        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {

            if (i == 0 || nums[i] != nums[i - 1]) {

                int leftIndex = i + 1;
                int rightIndex = nums.length - 1;

                while (leftIndex < rightIndex) {
                    int sum = nums[i] + nums[leftIndex] + nums[rightIndex];
                    if (sum < 0) {
                        leftIndex++;
                    } else if (sum > 0) {
                        rightIndex--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[leftIndex], nums[rightIndex]));
                        leftIndex++;
                        rightIndex--;
                        while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex - 1]) {
                            leftIndex++;
                        }
                    }

                }

            }

        }

        return result;
    }

}
