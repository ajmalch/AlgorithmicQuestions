package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SingleCycleCheckTest {

    SingleCycleCheck singleCycleCheck = new SingleCycleCheck();

    @Test
    void singleCycleCheck() {
        int[] array = new int[]{2, 3, 1, -4, -4, 2};
        assertTrue(singleCycleCheck.singleCycleCheck(array));
        assertTrue(singleCycleCheck.singleCycleCheck2(array));

        array = new int[]{2, 3, 1, 7, 4, -5 - 4, -4, 2};
        assertFalse(singleCycleCheck.singleCycleCheck(array));
        assertFalse(singleCycleCheck.singleCycleCheck2(array));

    }

}