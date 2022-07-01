package com.example;

/**
 * Given an integer array nums sorted in non-decreasing order,
 * remove the duplicates in-place such that each unique element appears only once.
 * The relative order of the elements should be kept the same.
 * <p>
 * Since it is impossible to change the length of the array in some languages,
 * you must instead have the result be placed in the first part of the array nums.
 * More formally, if there are k elements after removing the duplicates,
 * then the first k elements of nums should hold the final result.
 * It does not matter what you leave beyond the first k elements.
 * <p>
 * Return k after placing the final result in the first k slots of nums.
 * <p>
 * Do not allocate extra space for another array.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 */

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {

        int leftIndex = 0;
        int rightIndex = 0;

        while (rightIndex < nums.length) {
            if (nums[leftIndex] == nums[rightIndex])
                rightIndex++;
            else
                nums[++leftIndex] = nums[rightIndex++];

        }
        return leftIndex + 1;
    }

}
