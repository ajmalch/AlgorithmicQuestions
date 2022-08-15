package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BinaryTreeTraversalsTest {

    TreeNode root;
    BinaryTreeTraversals treeTraversals = new BinaryTreeTraversals();

    @BeforeEach
    void setUp() {
        root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(22);
    }

    @Test
    void inOrderTraverse() {
        final List<Integer> inOrderResult = treeTraversals.inOrderTraverse(root, new ArrayList<>());
        Assertions.assertEquals(List.of(1, 2, 5, 5, 10, 15, 22), inOrderResult);
    }

    @Test
    void preOrderTraverse() {
        final List<Integer> preorderResult = treeTraversals.preOrderTraverse(root, new ArrayList<>());
        Assertions.assertEquals(List.of(10, 5, 2, 1, 5, 15, 22), preorderResult);
    }

    @Test
    void postOrderTraverse() {
        final List<Integer> postOrderResult = treeTraversals.postOrderTraverse(root, new ArrayList<>());
        Assertions.assertEquals(List.of(1, 2, 5, 5, 22, 15, 10), postOrderResult);
    }
}