package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OneAwayTest {

    private final OneAway oneAway = new OneAway();

    @Test
    void isOneEditAwayTest() {
        assertTrue(oneAway.isOneEditAway("pale", "ple"));
        assertTrue(oneAway.isOneEditAway("pales", "pale"));
        assertTrue(oneAway.isOneEditAway("pale", "pale"));
        assertFalse(oneAway.isOneEditAway("pales", "pal"));
        assertTrue(oneAway.isOneEditAway("pale", "bale"));
        assertFalse(oneAway.isOneEditAway("pale", "bake"));
    }
}