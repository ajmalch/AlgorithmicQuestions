package com.example;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

class GroupAnagramsTest {

    GroupAnagrams groupAnagrams = new GroupAnagrams();

    @Test
    void groupAnagramsTest() {

        String[] words = new String[]{"yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"};

        MatcherAssert.assertThat(groupAnagrams.groupAnagrams(words),
                Matchers.containsInAnyOrder(List.of
                                (List.of("flop", "olfp"), List.of("act", "tac", "cat"), List.of("yo", "oy"), List.of("foo"))
                        .toArray())
        );
    }
}