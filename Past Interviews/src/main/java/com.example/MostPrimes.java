package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given an M*N matrix and return the maximum occurred prime numbers in a straight line in any direction.
 * The line may not start or end at the edge of the matrix
 */
public class MostPrimes {

    private List<Integer> result = new ArrayList<>();
    Map<Integer, Integer> primeCount = new HashMap<>();
    int currMax = 0;

    public List<Integer> getMaxPrimes(int[][] matrix) {

        if (matrix == null || matrix.length == 0)
            return result;

        int height = matrix.length;
        int width = matrix[0].length;

        for (int i = 0; i < height; i++) {

            for (int j = 0; j < width; j++) {
                dfs(i, j, height, width, matrix, 0, 1, 0);
                dfs(i, j, height, width, matrix, 1, 1, 0);
                dfs(i, j, height, width, matrix, 2, 1, 0);
                dfs(i, j, height, width, matrix, 3, 1, 0);
                dfs(i, j, height, width, matrix, 4, 1, 0);
                dfs(i, j, height, width, matrix, 5, 1, 0);
                dfs(i, j, height, width, matrix, 6, 1, 0);
                dfs(i, j, height, width, matrix, 7, 1, 0);

            }

        }
        return result;
    }

    private void dfs(int row, int col, int height, int width, int[][] matrix, int direction, int digitLength, int val) {

        if (row < 0 || col < 0 || row >= height || col >= width)
            return;

        int currVal = matrix[row][col];
        for (int i = 1; i < digitLength; i++) {
            currVal *= 10;
        }
        val += currVal;
        if (!isPrime(val)) {
            return;
        }

        primeCount.put(val, primeCount.getOrDefault(val, 0) + 1);

        if (primeCount.get(val) >= currMax) {
            if (primeCount.get(val) > currMax) {
                result.clear();
                currMax = primeCount.get(val);
            }
            result.add(val);
        }

        switch (direction) {

            case 0 -> dfs(row - 1, col - 1, height, width, matrix, direction, digitLength + 1, val);
            case 1 -> dfs(row, col - 1, height, width, matrix, direction, digitLength + 1, val);
            case 2 -> dfs(row + 1, col - 1, height, width, matrix, direction, digitLength + 1, val);
            case 3 -> dfs(row + 1, col, height, width, matrix, direction, digitLength + 1, val);
            case 4 -> dfs(row + 1, col + 1, height, width, matrix, direction, digitLength + 1, val);
            case 5 -> dfs(row, col + 1, height, width, matrix, direction, digitLength + 1, val);
            case 6 -> dfs(row - 1, col + 1, height, width, matrix, direction, digitLength + 1, val);
            case 7 -> dfs(row - 1, col, height, width, matrix, direction, digitLength + 1, val);

        }


    }


    private boolean isPrime(int number) {
        return Math.random() >= .5;
    }

}
