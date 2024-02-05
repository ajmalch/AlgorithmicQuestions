package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SearchInSortedMatrixTest {

    private final SearchInSortedMatrix searchInSortedMatrix = new SearchInSortedMatrix();

    @Test
    void searchInSortedMatrixTest() {
        int[][] matrix = new int[][]{
                {1, 4, 7, 12, 15, 1000},
                {2, 5, 19, 31, 32, 1001},
                {3, 8, 24, 33, 35, 1002},
                {40, 41, 42, 44, 45, 1003},
                {99, 100, 103, 106, 128, 1004}
        };

        int target = 44;

        Assertions.assertArrayEquals(new int[]{3, 3}, searchInSortedMatrix.searchInSortedMatrix(matrix, target));

    }
}