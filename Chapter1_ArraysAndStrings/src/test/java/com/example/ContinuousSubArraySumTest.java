package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContinuousSubArraySumTest {

    ContinuousSubArraySum continuousSubArraySum = new ContinuousSubArraySum();

    @Test
    void checkSubarraySum() {
         assertTrue(continuousSubArraySum.checkSubarraySum(new int[]{11,3,16,1}, 5));
         assertTrue(continuousSubArraySum.checkSubarraySum(new int[]{11,1,1,1}, 7));
         assertFalse(continuousSubArraySum.checkSubarraySum(new int[]{11,3,16,1}, 8));

    }
}