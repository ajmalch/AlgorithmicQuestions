package com.example;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * <p>
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 */
public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        // keep k largest elements in the heap
        for (int n : nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // output
        return heap.poll();
    }


    public int findKthLargestQuickSelect(int[] nums, int k) {

        int size = nums.length;
        return quickSelect(0, size - 1, size - k, nums);

    }

    private int quickSelect(int left, int right, int kSmallest, int[] nums) {

        if (left == right)
            return nums[left];

        Random random = new Random();
        int pivotPosition = left + random.nextInt(right - left);

        int pivotIndex = partition(nums, left, right, pivotPosition);

        if (pivotIndex == kSmallest) {
            return nums[pivotIndex];
        }
        if (pivotIndex > kSmallest) {
            return quickSelect(left, pivotIndex - 1, kSmallest, nums);
        } else {
            return quickSelect(pivotIndex + 1, right, kSmallest, nums);
        }

    }


    private int partition(int[] nums, int left, int right, int pivotPosition) {

        int pivot = nums[pivotPosition];
        swap(nums, pivotPosition, right);
        int swapIndex = left;

        for (int i = left; i <= right; i++) {
            if (nums[i] < pivot) {
                swap(nums, swapIndex, i);
                swapIndex++;
            }
        }

        swap(nums, right, swapIndex);

        return swapIndex;
    }

    private void swap(int[] nums, int n1, int n2) {

        int temp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = temp;

    }

}
