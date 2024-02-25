package com.example;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SubsetsTest {

    private final Subsets subsets = new Subsets();

    @Test
    void subsetsTest() {

        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> powerset = subsets.subsets(nums);

        MatcherAssert.assertThat(powerset, Matchers.containsInAnyOrder(
                List.of(new ArrayList<Integer>(), List.of(1), List.of(2), List.of(3)
                , List.of(1,2), List.of(1,3), List.of(2,3)
                , List.of(1,2,3)).toArray()
        ));

    }
}