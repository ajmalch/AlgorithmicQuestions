package com.example;

/*
Given a string check if any of it's permutation is a palindrome string
There is no need to be dictionary word for palindrome
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.Character.getNumericValue;

public class PalindromPermutation {

    public static void main(String[] args) {

        List.of("ajmal", "cat go ca tgo", "cat tgtooth go ca ")
                .parallelStream()
                .forEach(input -> {
                            System.out.println("Original Method : " + input + " : " + isPalindromePermutation(input));
                            System.out.println("New Method : " + input + " : " + isPalindromePermutationBitVector(input));
                        }
                );

    }

    public static boolean isPalindromePermutation(String input) {

        if (input == null)
            return false;

        Set<Character> oddSet = new HashSet<>();

        for (char c : input.toCharArray()) {
            if (c != ' ')
                if (oddSet.contains(c))
                    oddSet.remove(c);
                else
                    oddSet.add(c);

        }
        return oddSet.size() <= 1;
    }

    /**
     * This soluition uses bit vector approach to get more performing solution
     *
     * @param input
     * @return
     */
    public static boolean isPalindromePermutationBitVector(String input) {

        final var bitVector = createBitVector(input);

        return bitVector == 0 || checkExactlyOneBitSet(bitVector);


    }

    /**
     * Check exactly one bit is set by subtracting one from the integer and ANDing it with the original integer
     *
     * @param bitVector
     * @return
     */
    private static boolean checkExactlyOneBitSet(int bitVector) {

        return (bitVector & (bitVector - 1)) == 0;
    }

    /**
     * Create a bit vector for the string. For each letter with value i, toggle the ith bit
     *
     * @param input
     * @return
     */
    private static int createBitVector(String input) {

        int bitVector = 0;

        for (char c : input.toCharArray()
        ) {
            int x = getNumericValue(c);
            bitVector = toggle(bitVector, x);
        }

        return bitVector;
    }

    /**
     * Toggle the ith bit in the integer
     *
     * @param bitVector
     * @param index
     * @return
     */
    private static int toggle(int bitVector, int index) {
        if (index < 0)
            return bitVector;
        int mask = 1 << index;
        if ((bitVector & mask) == 0) {
            bitVector |= mask;
        } else {
            bitVector &= ~mask;
        }
        return bitVector;
    }

}
