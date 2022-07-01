package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * Implement the MinStack class:
 * <p>
 * <p>
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 */
public class MinStack {

    Stack<List<Integer>> stack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty())
            stack.push(Arrays.asList(val, val));
        else
            stack.push(Arrays.asList(val, Math.min(val, getMin())));

    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()
                .get(0);
    }

    public int getMin() {
        return stack.peek()
                .get(1);
    }
}
