package com.example;

/*
This program is to solve if a string matches pattern with pattern string consists of only 2 letters a and b
For example, the string catcatgocatgo matches the pattern aabab( where a is cat and b is go)
It also matches patterns like a(the whole string), ab (a-> catcatgo, b-> catgo) and b (the whole string)
 */

public class PatternMatching {

    public static void main(String[] args) {

//        System.out.println(doesMatch("", ""));
//        System.out.println(doesMatch("", "random"));
//        System.out.println(doesMatch("aabab", "catcatgocatgo"));
        System.out.println(doesMatch("bbaba", "catcatgocatgo"));
//        System.out.println(doesMatch("b", "somestring"));


    }


    public  static boolean doesMatch(String pattern, String value){

        if(pattern.length() == 0) return value.length() == 0;

        int size = value.length();

        char mainChar = pattern.charAt(0);
        char altChar = mainChar == 'a' ? 'b' : 'a';

        int countOfMain = countOf(pattern, mainChar);
        int countOfAlt = pattern.length() - countOfMain;

        int firstAlt = pattern.indexOf(altChar);

        int maxMainSize = size / countOfMain;

        for(int mainSize =1; mainSize <= maxMainSize ; mainSize++){

            int remainingLength = size - mainSize*countOfMain;
            String first = value.substring(0,mainSize);

            if(countOfAlt == 0 || remainingLength % countOfAlt == 0){
                int altIndex = firstAlt*mainSize;
                int altSize = countOfAlt == 0 ? 0:remainingLength/countOfAlt;
                String second = countOfAlt == 0 ? "" :value.substring(altIndex, altIndex+altSize);

                if(match(pattern, first, second, value))
                    return true;

            }

        }

        return false;
    }

    private static boolean match(String pattern, String first, String second, String value) {

        char main = pattern.charAt(0);

        int index = 0;
        String compare;

        for(char c : pattern.toCharArray()){
            compare = (c== main)?first:second;
            if(value.startsWith(compare, index))
                index = index + compare.length();
            else
                return false;

        }
        return true;

    }


//    private static String buildFromPattern(String pattern, String main, String alt) {
//
//        StringBuilder sb = new StringBuilder();
//        char first = pattern.charAt(0);
//        for (char c: pattern.toCharArray()) {
//            if (c==first)
//                sb.append(main);
//            else
//                sb.append(alt);
//
//        }
//        return sb.toString();
//
//
//    }

    private static int countOf(String pattern, char ch){

        return pattern.length() - pattern.replaceAll(""+ch, "").length();
    }

}
