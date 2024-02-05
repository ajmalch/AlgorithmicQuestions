package com.example;

import java.util.Arrays;

/**
 * Find Three largest numbers
 * <p>
 * Write a function that takes an integer array  of at least three numbers and,
 * without sorting the input array , return the sorted array of three largest integers in the input array.
 * <p>
 * The function should return duplicate integers if necessary, for example it should return [10, 10, 12]
 * for an input array of [10, 5, 9, 10, 12].
 *
 */
public class ThreeLargest {


    /**
     * @param array integer array  of at least three numbers
     * @return sorted array of three largest integers in the input array
     * <p>
     * This solution has O(n) time complexity and O(n) space complexity
     */
    public int[] findThreeLargetsNumbers(int[] array) {

        int[] result = new int[3];
        Arrays.fill(result, Integer.MIN_VALUE);
        for (int num : array) {

            if (num > result[2]) {
                shiftArray(result, 2, num);
            } else if (num > result[1]) {
                shiftArray(result, 1, num);
            } else if (num > result[0]) {
                shiftArray(result, 0, num);
            }

        }

        return result;
    }

    private void shiftArray(int[] array, int index, int num) {

        int numToInsert = num;
        for (int i = index; i >= 0; i--) {
            int temp = array[i];
            array[i] = numToInsert;
            numToInsert = temp;
        }
    }
}