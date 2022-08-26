package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Write a function that takes in a non-empty array of integers and
 * returns the greatest sum that be generated from a strictly  increasing subsequence
 * in the array as well as an array of the numbers in that subsequence.
 */

public class MaxIncreasingSubSequence {


    public List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {

        int[] maxArray = new int[array.length];
        int[] seqArray = new int[array.length];
        Arrays.fill(seqArray, Integer.MIN_VALUE);
        int maxSeqEnd = 0;
        for (int i = 0; i < array.length; i++) {
            maxArray[i] = array[i];
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i] && maxArray[j] + array[i] >= maxArray[i]) {
                    maxArray[i] = maxArray[j] + array[i];
                    seqArray[i] = j;
                }
            }

            if (maxArray[i] > maxArray[maxSeqEnd]) {
                maxSeqEnd = i;
            }
        }

        List<Integer> maxList = new ArrayList<>();
        maxList.add(maxArray[maxSeqEnd]);
        int i = maxSeqEnd;
        List<Integer> sequenceList = new ArrayList<>();
        while (i != Integer.MIN_VALUE) {
            sequenceList.add(0, array[i]);
            i = seqArray[i];
        }
        return new ArrayList<>() {
            {
                add(maxList); //  max sum
                add(sequenceList); //  max sequence
            }
        };
    }

}
