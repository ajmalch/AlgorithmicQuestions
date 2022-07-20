package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */
public class GroupAnagrams {

    //O(n*l) time complexity where n is the number of words and l is the length of each word
    //O(n+l) space complexity
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            Map<Integer, Integer> countMap = new HashMap<>();
            IntStream.range(0, str.length())
                    .forEach(
                            i -> countMap.put(str.charAt(i) - 'a'
                                    , countMap.getOrDefault(str.charAt(i) - 'a', 0) + 1));
            StringBuilder sb = new StringBuilder();
            //iterate through all 26 characters
            IntStream.iterate(0, i -> i < 26, i -> i + 1)
                    .forEach(i -> sb.append("#")
                            .append(countMap.getOrDefault(i, 0)));
            String key = sb.toString();
            List<String> value = map.getOrDefault(key, new ArrayList<>());
            value.add(str);
            map.put(key, value);
        }

        return new ArrayList<>(map.values());
    }
}
