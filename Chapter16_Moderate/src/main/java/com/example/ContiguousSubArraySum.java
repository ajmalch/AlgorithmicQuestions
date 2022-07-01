package com.example;

/*
You are given an array of integers (positive and negative).
Find the contiguous sequence with largest sum
Eg:-
input {2, -8, 3, -2, 4, -10}
output 5 ie {3, -2, 4}
 */

public class ContiguousSubArraySum {

    public static void main(String[] args) {

        System.out.println(getContiguousSum(1, 2, -4, 2, -1, 3));
        System.out.println(getContiguousSum(-3, -5, -1, -2, -1));
        System.out.println(getContiguousSum(-3, -5, -7));
    }

    public static int getContiguousSum(int... input) {

        int maxSum = Integer.MIN_VALUE;

        int sum = 0;

        for (int i = 0; i < input.length; i++) {

            sum += input[i];

            if (sum > maxSum)
                maxSum = sum;

            if (sum < 0)
                sum = 0;

        }

        return maxSum;

    }

}
