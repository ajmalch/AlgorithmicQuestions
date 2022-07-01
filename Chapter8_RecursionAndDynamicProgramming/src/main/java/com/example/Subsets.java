package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class Subsets {

    List<List<Integer>> output = new ArrayList<>();
    int n;
    int k;

    public List<List<Integer>> subsets(int[] nums) {

        n = nums.length;
        for (k = 0; k <= n; k++) {
            backTrack(0, new ArrayList<Integer>(), nums);
        }

        return output;
    }

    private void backTrack(int index, List<Integer> curr, int[] nums) {

        if (curr.size() == k) {
            output.add(new ArrayList(curr));
            return;
        }
        for (int i = index; i < n; i++) {

            curr.add(nums[i]);
            backTrack(i + 1, curr, nums);
            curr.remove(curr.size() - 1);
        }
    }

}
