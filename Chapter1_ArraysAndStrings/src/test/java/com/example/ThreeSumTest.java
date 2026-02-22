package com.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ThreeSumTest {

    private Set<List<Integer>> toSet(List<List<Integer>> lists) {
        return new HashSet<>(lists);
    }

    @Test
    void exampleCase() {
        ThreeSum ts = new ThreeSum();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = ts.threeSum(nums);
        Set<List<Integer>> expected = new HashSet<>();
        expected.add(Arrays.asList(-1, -1, 2));
        expected.add(Arrays.asList(-1, 0, 1));
        assertEquals(expected, toSet(res));
    }

    @Test
    void exampleCaseWithMoreData() {
        ThreeSum ts = new ThreeSum();
        int[] nums = new int[]{-1, 0,-4, 1, 2, -1, -4,3,2,-1, 0,-4, 1, -5,2, -1, -4};
        List<List<Integer>> res = ts.threeSum(nums);
        Set<List<Integer>> expected = new HashSet<>();
        expected.add(Arrays.asList(-1, -1, 2));
        expected.add(Arrays.asList(-1, 0, 1));
        expected.add(Arrays.asList(-5,2,3));
        expected.add(Arrays.asList(-4,2,2));
        expected.add(Arrays.asList(-4,1,3));
        assertEquals(expected, toSet(res));
    }

    @Test
    void allZeros() {
        ThreeSum ts = new ThreeSum();
        int[] nums = new int[]{0, 0, 0, 0};
        List<List<Integer>> res = ts.threeSum(nums);
        Set<List<Integer>> expected = new HashSet<>();
        expected.add(Arrays.asList(0, 0, 0));
        assertEquals(expected, toSet(res));
    }

    @Test
    void noSolution() {
        ThreeSum ts = new ThreeSum();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        List<List<Integer>> res = ts.threeSum(nums);
        assertTrue(res.isEmpty());
    }

    @Test
    void smallInputs() {
        ThreeSum ts = new ThreeSum();
        assertTrue(ts.threeSum(new int[]{}).isEmpty());
        assertTrue(ts.threeSum(new int[]{0}).isEmpty());
        assertTrue(ts.threeSum(new int[]{0, 0}).isEmpty());
    }

}

