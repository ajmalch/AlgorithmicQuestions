package com.example;

import java.util.*;

/*
Given two strings, write a method to decide if one is a permutation of the other
 */
public class CheckPermutation {

    /**
     * O(nlogn where n is the length of the strings)
     *
     * @param s1 first input string
     * @param s2 second input string
     * @return true if one is a permutation of the other
     */
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

    /**
     * O(n) time and O(n) space
     *
     * @param s1 first input string
     * @param s2 second input string
     * @return true if one is a permutation of the other
     */
    public boolean checkPermutation2(String s1, String s2) {

        if (s1.length() != s2.length())
            return false;

        Map<Character, Integer> characterCountMap1 = new HashMap<>();
        Map<Character, Integer> characterCountMap2 = new HashMap<>();

        for (char c : s1.toCharArray()) {
            characterCountMap1.put(c, characterCountMap1.getOrDefault(c, 0) + 1);
        }
        for (char c : s2.toCharArray()) {
            characterCountMap2.put(c, characterCountMap2.getOrDefault(c, 0) + 1);
        }

        Set<Character> characters1 = characterCountMap1.keySet();
        Set<Character> characters2 = characterCountMap2.keySet();
        if (!characters1.containsAll(characters2))
            return false;
        for (char c : characters1) {
            if (!Objects.equals(characterCountMap1.get(c), characterCountMap2.get(c)))
                return false;
        }

        return true;
    }


}

