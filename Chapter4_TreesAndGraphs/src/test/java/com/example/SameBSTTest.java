package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SameBSTTest {

    SameBST sameBST = new SameBST();

    @Test
    void sameBSTTest() {
        assertTrue(sameBST.sameBsts(List.of(10, 15, 8, 12, 94, 81, 5, 2, 11), List.of(10, 8, 5, 15, 2, 12, 11, 94, 81)));
    }


}