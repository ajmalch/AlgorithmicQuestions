package com.example;

/**
 * Write a function that takes anon-empty string and returns a boolean representing
 * whether string is a palindrome or not
 */
public class PalindromeCheck {

    public boolean checkPalindrom(String str){
        int len = str.length();
        for(int i = 0 ; i < len/2 ; i++){
            if(str.charAt(i) != str.charAt(len-1-i))
                return false;
        }
        return true;
    }
}
