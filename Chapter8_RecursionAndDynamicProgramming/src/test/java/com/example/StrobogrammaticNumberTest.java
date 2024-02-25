package com.example;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

class StrobogrammaticNumberTest {

    StrobogrammaticNumber strobogrammaticNumber = new StrobogrammaticNumber();

    @Test
    void findStrobogrammatic() {

        MatcherAssert.assertThat(strobogrammaticNumber.findStrobogrammatic(3),
                Matchers.containsInAnyOrder(List.of("111","101","181",
                                                    "609","619","689",
                                                    "906","916","986",
                                                    "808","818","888").toArray()));

    }
}