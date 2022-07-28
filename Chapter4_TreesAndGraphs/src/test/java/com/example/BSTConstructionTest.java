package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BSTConstructionTest {

    BSTConstruction bstConstruction;

    @BeforeEach
    void setUp() {
        bstConstruction = new BSTConstruction(10);
        bstConstruction.insert(15);
        bstConstruction.insert(5);
        bstConstruction.insert(5);
        bstConstruction.insert(2);
        bstConstruction.insert(13);
        bstConstruction.insert(14);
        bstConstruction.insert(1);
        bstConstruction.insert(22);
        bstConstruction.insert(12);
    }

    @Test
    void insert() {

        assertEquals(15, bstConstruction.getRight()
                .getVal());
        assertEquals(5, bstConstruction.getLeft()
                .getVal());
        assertEquals(5, bstConstruction.getLeft()
                .getRight()
                .getVal());
        assertEquals(2, bstConstruction.getLeft()
                .getLeft()
                .getVal());
        assertEquals(13, bstConstruction.getRight()
                .getLeft()
                .getVal());
        assertEquals(14, bstConstruction.getRight()
                .getLeft()
                .getRight()
                .getVal());
        assertEquals(1, bstConstruction.getLeft()
                .getLeft()
                .getLeft()
                .getVal());
        assertEquals(22, bstConstruction.getRight()
                .getRight()
                .getVal());
        assertEquals(12, bstConstruction.getRight()
                .getLeft()
                .getLeft()
                .getVal());

    }

    @Test
    void contains() {
        assertTrue(bstConstruction.contains(15));

    }

    @Test
    void remove() {

        bstConstruction.remove(10);
        assertEquals(12, bstConstruction.getVal());
        assertEquals(15, bstConstruction.getRight()
                .getVal());
        assertEquals(5, bstConstruction.getLeft()
                .getVal());
        assertEquals(5, bstConstruction.getLeft()
                .getRight()
                .getVal());
        assertEquals(2, bstConstruction.getLeft()
                .getLeft()
                .getVal());
        assertEquals(13, bstConstruction.getRight()
                .getLeft()
                .getVal());
        assertEquals(14, bstConstruction.getRight()
                .getLeft()
                .getRight()
                .getVal());
        assertEquals(1, bstConstruction.getLeft()
                .getLeft()
                .getLeft()
                .getVal());
        assertEquals(22, bstConstruction.getRight()
                .getRight()
                .getVal());
    }
}