package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PeakElementTest {

    private final PeakElement peakElement = new PeakElement();

    @Test
    void findPeakElementIndexTest() {

        Assertions.assertEquals(2, peakElement.findPeakElementIndex(new int[]{3, 4, 5}));
        Assertions.assertEquals(0, peakElement.findPeakElementIndex(new int[]{6, 4, 3}));
        Assertions.assertEquals(9, peakElement.findPeakElementIndex(new int[]{6, 4, 3, 5, 6, 7, 9, 2, 4, 5}));

    }
}