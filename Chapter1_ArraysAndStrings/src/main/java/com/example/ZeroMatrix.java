package com.example;

/**
 * Write an algorithm such that if an element in an M*N matrix is 0
 * it's entire row and column set to 0
 */
public class ZeroMatrix {

    public static void main(String[] args) {

        int[][] input = new int[3][3];
        input[0][0] = 12;
        input[0][1] = 45;
        input[0][2] = 43;
        input[1][0] = 0;
        input[1][1] = 67;
        input[1][2] = 23;
        input[2][0] = 75;
        input[2][1] = 16;
        input[2][2] = 6;

        printArray(input);

        setZeros(input);
        System.out.println("Result :- ");
        printArray(input);

    }

    private static void setZeros(int[][] input) {

        boolean[] row = new boolean[input.length];
        boolean[] column = new boolean[input[0].length];

        //Iterate through whole matrix and set rows and columns to set to zero
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        //Set the rows to zero
        for (int i = 0; i < row.length; i++) {
            if (row[i])
                nullifyRow(i, input);
        }

        //Set the columns to zero
        for (int i = 0; i < column.length; i++) {
            if (column[i])
                nullifyColumn(i, input);
        }
    }

    private static void nullifyRow(int row, int[][] input) {

        for (int column = 0; column < input[0].length; column++) {
            input[row][column] = 0;
        }

    }

    private static void nullifyColumn(int column, int[][] input) {

        for (int row = 0; row < input.length; row++) {
            input[row][column] = 0;
        }

    }

    static void printArray(int[][] input) {

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
    }

}
