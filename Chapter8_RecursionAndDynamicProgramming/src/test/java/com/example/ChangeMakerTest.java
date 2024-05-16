package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChangeMakerTest {

    private final ChangeMaker changeMaker = new ChangeMaker();

    @Test
    void numberOfWaysToMakeChangeTest() {
        assertEquals(2,changeMaker.numberOfWaysToMakeChange(6, new int[]{1,5}));
        assertEquals(4,changeMaker.numberOfWaysToMakeChange(10, new int[]{10,5,1}));
    }
}