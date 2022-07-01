package com.example;


/**
 * Implement a method to perform basic string compression using the counts of adjacent repeated characters.
 * For example, the string abcccaaaadd will become a1b1c3a4d2
 * If the compressed string would not become smaller than  original string, method should return original string
 * Assume that only uppercase and lower case letters are present in the input
 * */
public class StringCompression {

    public static void main(String[] args) {

        System.out.println(compressed("abcccaaaadd"));
        System.out.println(compressed("ajmal"));
    }

    static String compressed(String input){

        StringBuilder compressed = new StringBuilder();

        int countConsecutive = 0;
        for (int i = 0; i < input.length(); i++) {

            countConsecutive++;

            //Check if current letter is same as next letter or if current one is the last letter
            if(i == input.length()-1 || input.charAt(i)!=input.charAt(i+1)){
                compressed.append(input.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive=0;
            }
        }
        return  compressed.length()<input.length()?compressed.toString():input;
    }

}

