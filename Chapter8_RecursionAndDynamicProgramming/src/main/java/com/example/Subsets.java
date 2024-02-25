package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class Subsets {



    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            backTrack(nums, i, 0, new ArrayList<>(),  result);
        }
        return result;
    }

    private void backTrack(int[] nums, int size, int index, List<Integer> list, List<List<Integer>> result) {

        if(size == list.size()){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index ; i< nums.length; i++) {
            list.add(nums[i]);
            backTrack(nums,size,i+1, list, result);
            list.remove(list.size()-1);
        }

    }


}
