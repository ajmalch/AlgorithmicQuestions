package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Given two strings s and t of lengths m and n respectively,
 * return the minimum window substring of s such that every character in t (including duplicates) is included in the window.
 * If there is no such substring, return the empty string "".
 * <p>
 * The testcases will be generated such that the answer is unique.
 * <p>
 * A substring is a contiguous sequence of characters within the string.
 */
public class MinimumWindowSubString {


    public static void main(String[] args) {

        System.out.println("minWindow(\"ADOBECODEBANC\",\"ABC\") :" + minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> dictT = new HashMap<Character, Integer>();

        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        int required = dictT.size();

        // Filter all the characters from s into a new list along with their index.
        // The filtering criteria is that the character should be present in t.
        List<Map<Integer, Character>> filteredS = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (dictT.containsKey(c)) {
                filteredS.add(Map.of(i, c));
            }
        }

        int l = 0, r = 0, formed = 0;
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();
        int currentLength = -1;
        int currentStart = 0;
        int currentEnd = 0;

        // Look for the characters only in the filtered list instead of entire s.
        // This helps to reduce our search.
        // Hence, we follow the sliding window approach on as small list.
        while (r < filteredS.size()) {
            char c = filteredS.get(r)
                    .values()
                    .stream()
                    .findFirst()
                    .get();
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            if (dictT.containsKey(c) && windowCounts.get(c)
                    .intValue() == dictT.get(c)
                    .intValue()) {
                formed++;
            }

            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (l <= r && formed == required) {
                c = filteredS.get(l)
                        .values()
                        .stream()
                        .findFirst()
                        .get();

                // Save the smallest window until now.
                int end = filteredS.get(r)
                        .keySet()
                        .stream()
                        .findFirst()
                        .get();
                int start = filteredS.get(l)
                        .keySet()
                        .stream()
                        .findFirst()
                        .get();
                if (currentLength == -1 || end - start + 1 < currentLength) {
                    currentLength = end - start + 1;
                    currentStart = start;
                    currentEnd = end;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c)
                        .intValue() < dictT.get(c)
                        .intValue()) {
                    formed--;
                }
                l++;
            }
            r++;
        }
        return currentLength == -1 ? "" : s.substring(currentStart, currentEnd + 1);
    }
}
