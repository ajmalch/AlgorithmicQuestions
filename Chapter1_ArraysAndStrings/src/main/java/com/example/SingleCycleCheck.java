package com.example;

import java.util.HashSet;
import java.util.Set;

/**
 * You're given an array of integers where each integer represents
 * a jump of its value in the array. For instance, the integer 2 represents a jump of
 * two indices forward in the array;
 * the integer -3 represents a jump of three indices backward in the array.
 * If a jump spills past the array's bounds,it wraps over to the other side.
 * For instance, a jump of -1 at index 0 brings us to the last index in the array.
 * Similarly, a jump of 1 at the last index in the array brings us to index 0 .
 * Write a function that returns a boolean representing whether the jumps in the array form a single cycle.
 * A single cycle occurs if, starting at any index in the array and following the jumps,
 * every element in the array is visited exactly once before landing back on the starting index.
 */
public class SingleCycleCheck {

    //O(n) time and O(1) space
    public boolean singleCycleCheck(int[] array) {
        int currIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (currIndex == 0 && i > 0) return false;
            currIndex = (currIndex + array[currIndex]) % array.length;
            if (currIndex < 0)
                currIndex = array.length + currIndex;

        }
        return currIndex == 0;
    }

    //O(n) time and O(n) space , but some optimization to return false faster
    public boolean singleCycleCheck2(int[] array) {
        int currIndex = 0;
        Set<Integer> visitorSet = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            currIndex = (currIndex + array[currIndex]) % array.length;
            if (currIndex < 0)
                currIndex = array.length + currIndex;
            if (visitorSet.contains(currIndex))
                return false;
            visitorSet.add(currIndex);
        }
        return currIndex == 0;
    }


}
