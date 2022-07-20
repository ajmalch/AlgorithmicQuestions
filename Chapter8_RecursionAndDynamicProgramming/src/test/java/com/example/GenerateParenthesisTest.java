package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GenerateParenthesisTest {

    private final GenerateParenthesis generateParenthesis = new GenerateParenthesis();

    @Test
    void generateParenthesisTest1() {
        final var parentheses = generateParenthesis.generateParenthesis(1);
        assertEquals(List.of("()"), parentheses);
    }

    @Test
    void generateParenthesisTest2() {
        final var parentheses = generateParenthesis.generateParenthesis(2);
        assertThat(parentheses, containsInAnyOrder("(())", "()()"));
    }

    @Test
    void generateParenthesisTest3() {
        final var parentheses = generateParenthesis.generateParenthesis(3);
        assertThat(parentheses, containsInAnyOrder("((()))", "(())()", "()(())", "()()()", "(()())"));
    }
}