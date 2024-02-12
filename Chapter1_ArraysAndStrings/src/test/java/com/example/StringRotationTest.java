package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringRotationTest {

    private final StringRotation stringRotation = new StringRotation();

    @Test
    void isRotationTest() {

        assertFalse(stringRotation.isRotation("ajmal", "ajmas"));
        assertTrue(stringRotation.isRotation("waterbottle", "waterbottle"));
        assertTrue(stringRotation.isRotation("waterbottle", "erbottlewat"));

    }
}