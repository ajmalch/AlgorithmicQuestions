package com.example;

import java.util.Stack;

/**
 * Write a function that takes a psitive integer represented as a string
 * number and an integer numDigits. Remove numDigits from the string so that the number represented by the string is as large as possible afterwards.
 * Note that the order of the remaining digits cannot be changed.
 * You can assume numDigits will always be less than the length of number and greater than or equal to 0:
 */
public class BestDigits {



    public String bestDigits(String number, int numDigits){

        if(numDigits == 0) return number;
        int digitsToRemove = numDigits;
        Stack<Integer> stack = new Stack<>();
        for(char c : number.toCharArray()){
            int  digit = c-'0';
            while(!stack.empty() && stack.peek()<digit && digitsToRemove > 0){
                stack.pop();
                digitsToRemove--;
            }
            stack.push(digit);
        }
        while (digitsToRemove > 0 ){
            stack.pop();
            digitsToRemove--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}
