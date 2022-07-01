package com.example;

/**
 * You are given an integer array height of length n.
 * There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * <p>
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * <p>
 * Return the maximum amount of water a container can store.
 * <p>
 * Notice that you may not slant the container.
 */
public class WaterContainer {

    public int maxArea(int[] height) {

        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {

            maxArea = Math.max(maxArea, Math.min(
                    height[left], height[right]) * (right - left));

            if (height[left] < height[right])
                left++;
            else
                right--;

        }

        return maxArea;
    }
}
