package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RightSmallerThanTest {

    RightSmallerThan rightSmallerThan = new RightSmallerThan();

    @Test
    void rightSmallerThanTest1() {

        Assertions.assertEquals(List.of(5, 4, 4, 0, 1, 1, 0), rightSmallerThan.rightSmallerThan(List.of(8, 5, 11, -1, 3, 4, 2)));

    }

    @Test
    void rightSmallerThanTest2() {

        Assertions.assertEquals(List.of(), rightSmallerThan.rightSmallerThan(List.of()));

    }

    @Test
    void rightSmallerThanTest3() {

        Assertions.assertEquals(List.of(0), rightSmallerThan.rightSmallerThan(List.of(0)));

    }

    @Test
    void rightSmallerThanTest4() {

        Assertions.assertEquals(List.of(0, 0, 0, 0, 0, 0), rightSmallerThan.rightSmallerThan(List.of(1, 1, 1, 1, 1, 1)));

    }

}
