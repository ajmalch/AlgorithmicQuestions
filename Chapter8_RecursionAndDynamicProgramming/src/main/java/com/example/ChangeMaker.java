package com.example;

/*
   Given an array of distinct positive integers representing coin denominations and a single non-negative integer n
   representing a target amount of money, write a function that returns the number of ways to make change for that target amount
   using the given coin denominations.
   Note that an unlimited amount of coins is at your disposal.
 */

import java.util.*;

class ChangeMaker {
    public int numberOfWaysToMakeChange(int n, int[] denoms) {

        int[] ways = new int[n+1];
        Arrays.fill(ways, 0);
        ways[0] = 1;

        for(int denom : denoms){
            for(int i=0; i<ways.length; i++){
                if(denom<=i){
                    ways[i]+=ways[i-denom];
                }
            }
        }

        return ways[n];
    }
}