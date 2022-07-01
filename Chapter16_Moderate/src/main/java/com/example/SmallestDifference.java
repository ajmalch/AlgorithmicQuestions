package com.example;

import java.util.Arrays;

import static java.lang.Math.*;

/*
Given two arrays of integers
Find the pair of values which has the smallest difference and return the difference
 */
public class SmallestDifference {

    public static void main(String[] args) {

        int[] a1 = { 1, 3, 15, 11, 2};
        int[] b1 = {23, 127, 235, 19, 8};
        int[] a2 = {1, 2, 11, 15};
        int[] b2 = {4, 12, 19, 23, 127, 235 };


        System.out.println(smallestDifference(a1, b1));
        System.out.println(smallestDifference(a2, b2));
        System.out.println(smallestDifference(b1, b2));

    }

    static int smallestDifference(int[] array1 , int[] array2){

        int difference = Integer.MAX_VALUE;

        Arrays.sort(array1);
        Arrays.sort(array2);

        int a=0, b = 0;

        while(a < array1.length && b < array2.length){

            if(abs(array1[a] - array2[b]) < difference)
                difference = abs(array1[a] -array2[b]);

            if(array1[a] == array2[b])
                return 0;
            else if (array1[a] < array2[b])
                a++;
            else
                b++;
        }



        return  difference;
    }

}
