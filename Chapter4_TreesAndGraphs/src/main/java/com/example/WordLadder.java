package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words
 * beginWord -> s1 -> s2 -> ... -> sk such that:
 * <p>
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList,
 * return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> words = new HashSet<>(wordList);

        //When endword is not dictionary , return 0;
        if (!words.contains(endWord)) return 0;

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();


        beginSet.add(beginWord);
        endSet.add(endWord);

        int length = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {

            //since we re searching from both sides - bidirectional BFS
            //swap the beginSEt and endSet so that beginSet is always biggest
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            Set<String> newBeginSet = new HashSet<>();

            for (String word : beginSet) {
                List<String> neighbors = neighbors(word);
                for (String neighbor : neighbors) {
                    if (endSet.contains(neighbor)) return length + 1;

                    if (words.contains(neighbor)) {
                        newBeginSet.add(neighbor);
                        words.remove(neighbor);
                    }
                }
            }

            beginSet = newBeginSet;
            length++;
        }

        return 0;

    }


    private List<String> neighbors(String s) {

        List<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            char temp = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != temp) {
                    chars[i] = c;
                    String neighbor = new String(chars);
                    result.add(neighbor);
                }
            }
            chars[i] = temp;

        }

        return result;

    }
}
