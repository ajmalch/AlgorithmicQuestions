package com.example;

import java.util.Arrays;

/*
Given two strings, write a method to decide if one is a permutation of the other
 */
public class CheckPermutation {

    public boolean checkPermutation(String s1, String s2) {

        //One can be permutation of the other only if they are of the same length
        if (s1.length() != s2.length())
            return false;

        return sort(s1).equals(sort(s2));

    }

    public  String sort(String s) {

        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);

    }
}

