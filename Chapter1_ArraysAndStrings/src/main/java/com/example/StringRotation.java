package com.example;

public class StringRotation {


    public static void main(String[] args) {
        System.out.println("ajmal is a rotation of ajmas :" + isRotation("ajmal", "ajmas"));
        System.out.println("waterbottle is a rotation of waterbottle :" + isRotation("waterbottle", "waterbottle"));
        System.out.println("waterbottle is a rotation of erbottlewat :" + isRotation("waterbottle", "erbottlewat"));
    }


    static boolean isRotation(String s1, String s2){
        if (s1.length() >0 && s1.length()==s2.length()) {
            return (s1+s1).contains(s2);
        }
        return false;
    }
}
