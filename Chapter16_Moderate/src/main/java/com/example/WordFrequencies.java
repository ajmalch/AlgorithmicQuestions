package com.example;

/*
Design a method to find frequency of occurrences of a word in an book (array of words)
Also think about if we want to repeat this operation (same or different words)
 */

import java.util.HashMap;
import java.util.Map;

public class WordFrequencies {

    public static void main(String[] args) {

        String[] book  = {"Ajmal", "Maliha", "Shadiya", "Cholassery" , "Aqila", "Ajmal", "Cholassery","cholassery"};

        System.out.println(getOccurrences(book, "ajmal"));
        System.out.println(getOccurrences(book, "John"));
        System.out.println(getOccurrences(book, "Cholassery"));

        Map<String, Integer> dictionary =  setUpDictionary(book);

        System.out.println(dictionary);
        System.out.println(getFrequency(dictionary, "Aqila"));
        System.out.println(getFrequency(dictionary, "ajmal"));

    }

    static int getOccurrences(String[] book, String word){

        int count  = 0;

        for(var  w : book){
            if(w.equalsIgnoreCase(word))
                count++;
        }
        return  count;

    }

    /*For repetitive calls, we may create a dictionary of words with their occurrences
     */

    static Map<String, Integer> setUpDictionary(String[] book){

        Map<String,Integer>  dictionary = new HashMap<>();

        for(String word : book){
            if(!word.isBlank()){
                word = word.toLowerCase();
                if( dictionary.containsKey(word))
                    dictionary.put(word, dictionary.get(word)+1);
                else
                    dictionary.put(word, 1);

            }


        }

        return dictionary;

    }

    static int getFrequency(Map<String, Integer> dictionary, String word){

        if(dictionary == null || word == null) return  -1;

        word = word.toLowerCase();
        if(dictionary.containsKey(word))
            return  dictionary.get(word);

        return  0;

    }

}
