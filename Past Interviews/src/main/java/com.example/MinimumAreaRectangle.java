package com.example;

import java.util.HashSet;
import java.util.Set;

public class MinimumAreaRectangle {


    public static void main(String[] args) {

        MinimumAreaRectangle minimumAreaRectangle = new MinimumAreaRectangle();

        int[][] points = {
                {1, 5},
                {5, 1},
                {4, 2},
                {2, 4},
                {2, 2},
                {1, 2},
                {4, 5},
                {2, 5},
                {-1, -2}
        };

        System.out.println(minimumAreaRectangle.minimumAreaRectangle(points));

    }


    public int minimumAreaRectangle(int[][] points) {
        // Write your code here.
        Set<String> pointSet = createPointsSet(points);
        int minArea = Integer.MAX_VALUE;

        for (int i = 0; i < points.length - 1; i++) {

            int p1x = points[i][0];
            int p1y = points[i][1];

            for (int j = i + 1; j < points.length; j++) {

                int p2x = points[j][0];
                int p2y = points[j][1];
                if (p1x == p2x || p1y == p2y) continue;

                if (pointSet.contains(convertPoint(p1x, p2y)) &&
                        pointSet.contains(convertPoint(p2x, p1y))) {
                    minArea = Math.min(minArea, Math.abs(p1x - p2x) * Math.abs(p1y - p2y));
                }

            }
        }

        if (minArea == Integer.MAX_VALUE)
            return 0;

        return minArea;
    }


    private String convertPoint(int pointX, int pointY) {
        return pointX + ":" + pointY;
    }

    private Set<String> createPointsSet(int[][] points) {

        Set<String> pointSet = new HashSet<>();
        for (int[] point : points) {
            pointSet.add(point[0] + ":" + point[1]);
        }
        return pointSet;
    }

}
