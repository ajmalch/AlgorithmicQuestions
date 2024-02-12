package com.example;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * <p>
 * If such an arrangement is impossible, it must rearrange it to the lowest possible order (i.e., sorted in ascending order).
 * <p>
 * The replacement must be in place and use only constant extra memory.
 */
public class NextPermutation {

    //O(n) time complexity algorith
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //find first dip from right (if there)
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) { //if the dip is found, find the first number from right which is higher than the dip number (there should be one as we found a dip)
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j); //swap the number found and the dip.
        }
        reverse(nums, i + 1); // after swapping , reverse the right side to get smaller permutation(the right side numbers are already sorted at this stage)
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
