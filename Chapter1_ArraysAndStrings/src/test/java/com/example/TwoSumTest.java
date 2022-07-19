package com.example;

import org.apache.commons.lang3.ArrayUtils;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class TwoSumTest {

    TwoSum twoSum = new TwoSum();

    @Test
    void twoSumTest() {

        MatcherAssert.assertThat(Arrays.asList(ArrayUtils.toObject(twoSum.twoSum(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 10)))
                , Matchers.containsInAnyOrder(6, 4));


    }
}