package com.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesTest {

    private final RemoveDuplicates removeDuplicates = new RemoveDuplicates();

    @Test
    void removeDuplicates() {
        int[] input = new int[] {1,1,3,4,4,4,4,8, 8, 9,10,11,11, 12};

        final int index = removeDuplicates.removeDuplicates(input);

        assertArrayEquals(new int[] {1,3,4,8,9,10,11,12}, Arrays.copyOfRange(input, 0, index));

    }
}