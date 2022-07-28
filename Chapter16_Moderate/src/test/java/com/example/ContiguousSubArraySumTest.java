package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ContiguousSubArraySumExtension.class)
class ContiguousSubArraySumTest {

    @Test
    void getContiguousSum(ContiguousSubArraySum contiguousSubArraySum) {

        assertEquals(4, contiguousSubArraySum.getContiguousSum(1, 2, -4, 2, -1, 3));
        assertEquals(-1, contiguousSubArraySum.getContiguousSum(-3, -5, -1, -2, -1));
        assertEquals(-3, contiguousSubArraySum.getContiguousSum(-3, -5, -7));

    }
}