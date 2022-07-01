package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 */

public class ApartmentSearch {


    public static void main(String[] args) {

        final var blocks = List.of(Map.of("gym", false, "school", true, "store", false)
                , Map.of("gym", true, "school", false, "store", false)
                , Map.of("gym", true, "school", true, "store", false)
                , Map.of("gym", false, "school", true, "store", false)
                , Map.of("gym", false, "school", true, "store", true));

        apartmentHunting(blocks, new String[]{"gym", "school", "store"});


    }


    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        // Write your code here.

        int[] maxDistance = new int[blocks.size()];
        Arrays.fill(maxDistance, 0);

        for (String req : reqs) {
            int[] reqDistance = new int[blocks.size()];
            for (int i = 0; i < blocks.size(); i++) {
                if (blocks.get(i)
                        .get(req))
                    reqDistance[i] = 0;
                else {
                    if (i == 0)
                        reqDistance[i] = blocks.size() + 1;
                    else
                        reqDistance[i] = reqDistance[i - 1] + 1;
                }
            }

            for (int i = blocks.size() - 2; i >= 0; i--) {
                reqDistance[i] = Math.min(reqDistance[i], reqDistance[i + 1] + 1);
            }

            for (int i = 0; i < maxDistance.length; i++) {
                maxDistance[i] = Math.max(maxDistance[i], reqDistance[i]);
            }
        }

        int minDistance = Integer.MAX_VALUE;
        int minDistanceIndex = -1;
        for (int i = 0; i < maxDistance.length; i++) {

            if (maxDistance[i] < minDistance) {
                minDistance = maxDistance[i];
                minDistanceIndex = i;
            }
        }

        return minDistanceIndex;
    }
}
