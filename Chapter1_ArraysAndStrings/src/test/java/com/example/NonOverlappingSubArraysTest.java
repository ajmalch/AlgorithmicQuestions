package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NonOverlappingSubArraysTest {

    private final NonOverlappingSubArrays nonOverlappingSubArrays = new NonOverlappingSubArrays();

    @Test
    public void testNonOverlappingSubArraySimpleCase(){
        assertEquals(2,nonOverlappingSubArrays.minSumOfLengths(new int []{3,2,2,4,3},3));
    }

    @Test
    public void testNonOverlappingSubArrayWithDifferentLengths(){
        assertEquals(2,nonOverlappingSubArrays.minSumOfLengths(new int []{7,3,4,7},7));
    }

    @Test
    public void testNonOverlappingSubArrayWithNonExistingSubArrays(){
        assertEquals(-1,nonOverlappingSubArrays.minSumOfLengths(new int []{4,3,2,6,2,3,4},6));
    }

    @Test
    public void testNonOverlappingSubArrayWithOverlaps(){
        assertEquals(-1,nonOverlappingSubArrays.minSumOfLengths(new int []{1,5,1},6));
    }


}