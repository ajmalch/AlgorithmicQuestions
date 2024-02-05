package com.example;

/**
 * You are given a two-dimensional array (Matrix) of distinct integers
 * and a target number.Each row in the matrix sorted, and each column is also sorted
 * the matrix doesn't necessarily have the same height and width.
 * <p>
 * Write a method that returns an array of the row and column indices of the target number
 * if it's contained in the matrix., otherwise [-1,-1]
 */
public class SearchInSortedMatrix {

    //O(n+m) time complexity , O(1) space complexity
    public int[] searchInSortedMatrix(int[][] matrix, int target) {
        int height = matrix.length;
        int width = matrix[0].length;

        int currRow = 0;
        int currColumn = width - 1;

        while (currRow < height && currColumn >= 0) {
            if (matrix[currRow][currColumn] == target) {
                return new int[]{currRow, currColumn};
            }
            if (matrix[currRow][currColumn] < target) {
                currRow++;
            } else {
                currColumn--;
            }
        }
        return new int[]{-1, -1};

    }

}
