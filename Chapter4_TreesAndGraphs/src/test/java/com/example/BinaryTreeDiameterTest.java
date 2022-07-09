package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeDiameterTest {

    private final BinaryTreeDiameter binaryTreeDiameter = new BinaryTreeDiameter();


    @Test
    void diameterOfBinaryTreeTest() {

        /*
                    A
                   / \
                  B   C
                     / \
                    D   E
                   /   /
                  F   H
                 /     \
                G       I
         */

        TreeNode root = new TreeNode();
        root.left = new TreeNode();
        root.right = new TreeNode();
        root.right.left = new TreeNode();
        root.right.right = new TreeNode();
        root.right.left.left = new TreeNode();
        root.right.left.left.left = new TreeNode();
        root.right.right.left = new TreeNode();
        root.right.right.left.right = new TreeNode();

        assertEquals(6, binaryTreeDiameter.diameterOfBinaryTree(root));
    }
}