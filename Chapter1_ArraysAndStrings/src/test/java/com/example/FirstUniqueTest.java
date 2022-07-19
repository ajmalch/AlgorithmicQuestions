package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstUniqueTest {

    private final FirstUnique firstUnique = new FirstUnique();

    @Test
    void FirstUniqueTest1() {
        assertEquals(1, firstUnique.firstUniqChar("ajmal"));
    }

    @Test
    void FirstUniqueTest2() {
        assertEquals(0, firstUnique.firstUniqChar("noripeat"));
    }

    @Test
    void FirstUniqueTest3() {
        assertEquals(-1, firstUnique.firstUniqChar("aaaaaaaa"));
    }

    @Test
    void FirstUniqueTest4() {
        assertEquals(0, firstUnique.firstUniqChar("rtwuiaa"));
    }

}