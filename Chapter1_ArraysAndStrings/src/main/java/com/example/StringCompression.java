package com.example;


/**
 * Implement a method to perform basic string compression using the counts of adjacent repeated characters.
 * For example, the string abcccaaaadd will become a1b1c3a4d2
 * If the compressed string would not become smaller than  original string, method should return original string
 * Assume that only uppercase and lower case letters are present in the input
 * */
public class StringCompression {


    // Time complexity O(n), space complexity O(n)
    public String compressed(String input){
        // StringBuilder to build the compressed string efficiently
        StringBuilder compressed = new StringBuilder();

        int countConsecutive = 0; // Counter for consecutive repeated characters
        for (int i = 0; i < input.length(); i++) {
            countConsecutive++; // Increment count for current character

            // Check if current letter is different from next letter or if it's the last character
            if(i == input.length()-1 || input.charAt(i)!=input.charAt(i+1)){
                compressed.append(input.charAt(i)); // Append character
                compressed.append(countConsecutive); // Append count
                countConsecutive=0; // Reset counter for next character sequence
            }
        }
        // Return compressed string only if it's shorter than the original
        return  compressed.length()<input.length()?compressed.toString():input;
    }

}
