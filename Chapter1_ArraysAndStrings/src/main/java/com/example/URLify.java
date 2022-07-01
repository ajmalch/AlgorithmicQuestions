package com.example;

/*
You will be given a string which may contain 0 or more spaces
You need to convert all intermediate spaces to %20 for URL friendly reading
 */
public class URLify {

    public static void main(String[] args) {

        System.out.println(replaceSpaces("Mr John  Smith    "));
    }

    public static String replaceSpaces(String input){

        if (input == null)
            return null;

        StringBuilder result = new StringBuilder();
        for (char c: input.trim().toCharArray()) {

            if(c==' ')
                result.append("%20");
            else
                result.append(c);
        }

        return result.toString();

    }
}
