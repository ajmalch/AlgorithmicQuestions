package com.example;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {

    public static void main(String[] args) {

        char[][] grid1 = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}

        };

        char[][] grid2 = new char[][]{{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };


        System.out.println("Islands in Grid 1 :" + numOfIslands(grid1));

        System.out.println("Islands in Grid 2 :" + numOfIslands(grid2));
    }

    private static int numOfIslands(char[][] grid) {

        int result = 0;
        int rows = grid.length;
        int columns = grid[0].length;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                if (grid[i][j] == '1') {
                    result++;
                    traverse(grid, i, j, rows, columns);
                }

            }

        }


        return result;

    }

    private static void traverse(char[][] grid, int i, int j, int rows, int columns) {

        if (i < 0 || j < 0 || i >= rows || j >= columns || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        traverse(grid, i + 1, j, rows, columns);
        traverse(grid, i - 1, j, rows, columns);
        traverse(grid, i, j + 1, rows, columns);
        traverse(grid, i, j - 1, rows, columns);
    }

}
