package com.example;

import java.util.*;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs.length == 0)
            return new ArrayList();
        Map<String, List<String>> map = new HashMap<>();
        int[] counts = new int[26];

        for (String s : strs) {

            Arrays.fill(counts, 0);
            char[] chars = s.toCharArray();
            for (char c : chars) counts[c - 'a']++;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(counts[i]);
            }
            String key = sb.toString();

            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key)
                    .add(s);
        }

        return new ArrayList(map.values());

    }
}