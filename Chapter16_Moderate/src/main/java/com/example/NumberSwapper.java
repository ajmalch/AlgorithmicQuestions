package com.example;

/*
Write function to swap two numbers without using a temporary variable
 */

public class NumberSwapper {

    public static void main(String[] args){

        int a = 5;
        int b = 7;

        System.out.println("Initial values of a:" + a + " and  b:" + b);

        a = a+b;
        b = a-b;
        a = a-b;


        System.out.println("Final values of a: " + a + " and b:" + b );

    }


}
