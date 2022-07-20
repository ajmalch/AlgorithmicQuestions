package com.example;

public class EncryptWord {

    static String findEncryptedWord(String s) {
        // Write your code here
        if(s.length()<2 ){
            return s;
        }
        int middleIndex=s.length()%2==0?(s.length()/2)-1:s.length()/2;
        char middleChar = s.charAt(middleIndex);
        StringBuilder builder = new StringBuilder(Character.toString(middleChar));
        if(middleIndex>0)
            builder.append(findEncryptedWord(s.substring(0,middleIndex)));
        if(middleIndex<s.length())
            builder.append(findEncryptedWord(s.substring(middleIndex+1)));

        return builder.toString();

    }

    public static void main(String[] args) {

        System.out.println(findEncryptedWord("abc"));
        System.out.println(findEncryptedWord("AjmalCholassery"));
    }
}
