package com.example;

import org.apache.commons.lang3.tuple.Pair;

import java.util.*;


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


    //O(n) tme complexity using sliding window technique. O(n) space complexity
    public String minWindow(String s, String t) {

        if (s.isEmpty() || t.isEmpty()) {
            return "";
        }

        Map<Character, Integer> targetCharterCount = new HashMap<>();
        for(char c : t.toCharArray()){
            targetCharterCount.put(c, targetCharterCount.getOrDefault(c,0)+1);
        }
        int required = targetCharterCount.size();

        int left = 0;
        int right = 0;
        int formed = 0;
        int currLength = -1;

        int currentStart = 0;
        int currentEnd = 0;

        Map<Character, Integer> windowCharacterCount = new HashMap<>();

        while (right < s.length()){
            final char currChar = s.charAt(right);
            if(targetCharterCount.containsKey(currChar)){
                windowCharacterCount.put(currChar, windowCharacterCount.getOrDefault(currChar,0)+1);
                if(Objects.equals(windowCharacterCount.get(currChar), targetCharterCount.get(currChar))){
                    formed++;
                }

                while(left<=right  && formed == required){
                    if(currLength == -1  || right-left+1 < currLength){
                        currLength = right-left+1;
                        currentStart = left;
                        currentEnd = right;
                    }
                    char leftChar = s.charAt(left);
                    if(windowCharacterCount.containsKey(leftChar)){
                        windowCharacterCount.put(leftChar, windowCharacterCount.get(leftChar)-1);
                        if(windowCharacterCount.get(leftChar) < targetCharterCount.get(leftChar)){
                            formed--;
                        }
                    }
                    left++;
                }
            }

            right++;
        }

        return currLength == -1 ? "" : s.substring(currentStart, currentEnd + 1);
    }

    //O(n) tme complexity using sliding window technique. O(n) space complexity
    //Optimized if the input string contains many other charcters than present in target string
    public String minWindowOptimized(String s, String t) {

        if (s.isEmpty() || t.isEmpty()) {
            return "";
        }

        Map<Character, Integer> dictT = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        int required = dictT.size();

        // Filter all the characters from s into a new list along with their index.
        // The filtering criteria is that the character should be present in t.
        List<Pair<Integer, Character>> filteredS = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (dictT.containsKey(c)) {
                filteredS.add(Pair.of(i, c));
            }
        }

        int l = 0, r = 0, formed = 0;
        Map<Character, Integer> windowCounts = new HashMap<>();
        int currentLength = -1;
        int currentStart = 0;
        int currentEnd = 0;

        // Look for the characters only in the filtered list instead of entire s.
        // This helps to reduce our search.
        // Hence, we follow the sliding window approach on as small list.
        while (r < filteredS.size()) {
            char c = filteredS.get(r).getValue();
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            if (dictT.containsKey(c) && windowCounts.get(c)
                    .intValue() == dictT.get(c)
                    .intValue()) {
                formed++;
            }

            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (l <= r && formed == required) {
                c = filteredS.get(l).getValue();

                // Save the smallest window until now.
                int end = filteredS.get(r).getKey();
                int start = filteredS.get(l).getKey();
                if (currentLength == -1 || end - start + 1 < currentLength) {
                    currentLength = end - start + 1;
                    currentStart = start;
                    currentEnd = end;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c) < dictT.get(c)) {
                    formed--;
                }
                l++;
            }
            r++;
        }
        return currentLength == -1 ? "" : s.substring(currentStart, currentEnd + 1);
    }
}
