package com.example;

import java.util.List;

/**
 * Given a square grid of integers and an integer value, maxSum
 * determine the maximum size of sub square grid so that
 *  sum of all elements of any sub grid of that size created from the input grid
 *  is less than or equal to maxSum
 */
public class MaxSquareSubGrid {



    public static int largestSubgridSize(List<List<Integer>> grid, int maxSum){
        int result=0;

        int rowSize = grid.size();
        grid.forEach(column -> {
            if(column.size()!=rowSize) throw new RuntimeException("Input grid is not square"); }
        );

        while(result<=rowSize){
            if(checkMaxSum(grid,result)>maxSum)
                return result-1;
            result++;
        }

        return rowSize;
    }

    /**
     * Method to return maximum sum value of a sub grid of input size created from input grid
     */
    private static int checkMaxSum(List<List<Integer>> grid, int size) {

        int maxSum = 0;

        for(int i=0; i<=grid.size()-size;i++){
            int currentSum = 0;
            for (int row=i;row<i+size;row++){
                for(int column=i;column<i+size;column++){
                    currentSum+=grid.get(row).get(column);
                }
            }
            if(currentSum>maxSum) maxSum=currentSum;
        }
        System.out.println("max sum for size "+size +" is "+maxSum);
        return maxSum;
    }


    public static void main(String[] args) {

        System.out.println("MaxSum Subgrid size :"+ largestSubgridSize(
                        List.of(List.of(2,7,2)
                        , List.of(3,3,3)
                        , List.of(4,4,4)),14));

        System.out.println("MaxSum Subgrid size :"+ largestSubgridSize(
                List.of(List.of(2,2,2)
                        , List.of(3,7,3)
                        , List.of(4,4,4)),30));
    }

}
