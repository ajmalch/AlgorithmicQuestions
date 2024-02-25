package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StaircaseTraversalTest {

    private final StaircaseTraversal staircaseTraversal = new StaircaseTraversal();
    @Test
    void staircaseTraversalTest() {
        assertEquals(5, staircaseTraversal.staircaseTraversal(4, 2));
    }
}