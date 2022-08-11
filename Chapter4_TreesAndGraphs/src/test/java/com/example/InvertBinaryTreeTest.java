package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InvertBinaryTreeTest {

    InvertBinaryTree invertBinaryTree = new InvertBinaryTree();

    @Test
    void invertBinaryTreeTest() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);

        invertBinaryTree.invertBinaryTree(root);

        assertEquals(1, root.val);
        assertEquals(2, root.right.val);
        assertEquals(3, root.left.val);
        assertEquals(4, root.right.right.val);
        assertEquals(5, root.right.left.val);
        assertEquals(6, root.left.right.val);
        assertEquals(7, root.left.left.val);
        assertEquals(8, root.right.right.right.val);
        assertEquals(9, root.right.right.left.val);

    }
}