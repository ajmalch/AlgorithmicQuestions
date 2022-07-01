package com.example;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/*
Implement an algorithm to determine if a string has all unique characters
Implement another method, which won't use additional data structure
 */
public class UniqueString {

    public static void main(String[] args) {

//        System.out.println(isUnique(null));
        System.out.println(isUnique("ajmal"));
        System.out.println(isUnique("qwertyio"));

        System.out.println(isUniqueNoDataStructure("ajmal"));
        System.out.println(isUniqueNoDataStructure("qwertyio"));

    }

    /*
    The time complexity of this algorithm is O(n)
    Space complexity of this is O(n)
     */
    public static boolean isUnique(String input){

        if (input == null || input.isEmpty())
            throw new IllegalArgumentException("input string can't be empty");

        Set<Character> characters = new HashSet<>();

        for(char c : input.toCharArray()){
            if(characters.contains(c))
                return false;

            characters.add(c);
        }

        return true;

    }

    /*
    Tho time complexity of this O(n^2) and space complexity is O(1)
     */
    public static boolean isUniqueNoDataStructure(String input){

        if (input == null || input.isEmpty())
        throw new IllegalArgumentException("input string can't be empty");
        return !IntStream.iterate(0,i ->i<input.length(),i->i+1)
                .anyMatch(i-> compareCharacter(input, i));

    }

    /**
     * utility method to check if the charcter at position is preasent again after that position
     * @param input
     * @param i
     * @return
     */
    private static boolean compareCharacter(String input, int i) {
        char character = input.charAt(i);
        return IntStream.iterate(i +1, j->j< input.length(), j->j+1)
                .filter(j->character== input.charAt(j))
                .findFirst().isPresent();
    }

}
