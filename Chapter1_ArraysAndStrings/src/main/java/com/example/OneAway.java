package com.example;

/*
Given two strings , find if they are one edit away
One edit away means you can insert, delete or replace maximum of one character from the first string
to change that to second string string

pale, ple -> true
pales, pale -> true
pale, bale -> true
pale,bake -> false
*/
public class OneAway {


//    public static boolean isOneEditAway(String first, String second){
//
//        int firstLength = first.length();
//        int secondLength = second.length();
//
//        if(firstLength == secondLength){
//            if(first.equals(second))
//                return true;
//            return checkOneReplaceAway(first,second);
//        }
//        else if (Math.abs(firstLength-secondLength)==1){
//            if(firstLength<secondLength)
//                return checkOneInsertAway(first, second);
//            return checkOneInsertAway(second, first);
//        }
//
//        return false;
//    }
//
//    private static boolean checkOneInsertAway(String first, String second) {
//
//        int firstLength = first.length();
//        int secondLength = second.length();
//
//        int index1 = 0;
//        int index2 = 0;
//
//        while(index1<firstLength &&  index2< secondLength){
//
//            if(first.charAt(index1) != second.charAt(index2)){
//
//                if(index1 != index2)
//                    return false;
//                index2++;
//
//            } else {
//                index1++;
//                index2++;
//            }
//
//        }
//
//        return true;
//
//    }

    public boolean isOneEditAway(String first, String second) {

        int firstLength = first.length();
        int secondLength = second.length();

        //fail if the length of the strings are too different
        if(Math.abs(firstLength-secondLength)>1)
            return false;

        //Reassign shorter string to s1 and longer to s2
        String s1 = firstLength<secondLength?first:second;
        String s2 = firstLength<secondLength?second:first;

        int index1 = 0;
        int index2 = 0;

        boolean foundDifference = false;

        while (index1<s1.length() && index2< s2.length()){

            if(s1.charAt(index1) != s2.charAt(index2)){
                //if already found one difference before , return false
                if(foundDifference)
                    return false;
                //set the found difference to true
                foundDifference = true;

                if(firstLength == secondLength)
                    index1++; //if both strings are of same length, increment shorter index
            }else{
                index1++;   //increment shorter index if the current character is not a difference
            }

            index2++;   //always increment longer index

        }

        return true;
    }
}
