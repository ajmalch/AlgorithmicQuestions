package com.example;

import java.util.Arrays;

/**
 * Given an image represented by N*N matrix where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degree.Can you do this in one place?
 */
public class RoatateMatrix {

    public static void main(String[] args) {

        int[][] input = new int[5][5];
        input[0][0] = 12;
        input[0][1] = 45;
        input[0][2] = 43;
        input[0][3] = 37;
        input[0][4] = 9;
        input[1][0] = 15;
        input[1][1] = 7;
        input[1][2] = 67;
        input[1][3] = 76;
        input[1][4] = 23;
        input[2][0] = 75;
        input[2][1] = 16;
        input[2][2] = 6;
        input[2][3] = 60;
        input[2][4] = 10;
        input[3][0] = 23;
        input[3][1] = 56;
        input[3][2] = 65;
        input[3][3] = 23;
        input[3][4] = 30;
        input[4][0] = 75;
        input[4][1] = 16;
        input[4][2] = 73;
        input[4][3] = 10;
        input[4][4] = 30;


        System.out.println("Input matrix");
        printArray(input);

        rotateMatrix(input);

        System.out.println("After Rotation");

        printArray(input);


    }

    static void printArray(int[][] input){

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                System.out.print(input[i][j] +" ");
            }
        System.out.println();
        }
    }


    static boolean rotateMatrix(int [][] matrix){

        if(matrix.length==0 || matrix.length != matrix[0].length) return false;

        int length = matrix.length;
        //iterate through each layers until we reach middle of the matrix
        for (int layer = 0; layer < length / 2; layer++) {

            int first = layer;
            int last = length-1-layer;//based on the layer we are in this value will be changed

            for (int i=first; i<last ; i++){

                int offset = i-first;
                //save top
                int top = matrix[first][i];
                //left to top
                matrix[first][i] = matrix[last - offset][first];
                //bottom to left
                matrix[last - offset][first] = matrix[last][last-offset];
                //right to bottom
                matrix[last][last-offset] = matrix[i][last];
                //saved top to right
                matrix[i][last] = top;
            }
        }

        return true;
    }


}
