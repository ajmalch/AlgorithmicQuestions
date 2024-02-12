package com.example;

public class StringRotation {


    public boolean isRotation(String s1, String s2){
        if (!s1.isEmpty() && s1.length()==s2.length()) {
            return (s1+s1).contains(s2);
        }
        return false;
    }
}
