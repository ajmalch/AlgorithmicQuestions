package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        final List<Integer> list = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());

        final List<List<Integer>> result = new ArrayList<>();
        backTrack(list, 0, result);

        return result;
    }

    private void backTrack(List<Integer> list, int index, List<List<Integer>> result) {

        if (index == list.size()) {
            result.add(list);
        }

        for (int i = index; i < list.size(); i++) {

            Collections.swap(list, index, i);
            backTrack(list, index, result);
            Collections.swap(list, index, i);
        }
        
    }
}
