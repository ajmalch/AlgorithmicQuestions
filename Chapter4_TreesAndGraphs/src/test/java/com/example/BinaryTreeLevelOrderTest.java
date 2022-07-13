package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeLevelOrderTest {

    BinaryTreeLevelOrder binaryTreeLevelOrder = new BinaryTreeLevelOrder();

    @Test
    void levelOrderTest() {

         /*
                    A
                   / \
                  B   C
                     / \
                    D   E
                   /   / \
                  F   H   J
                 /     \
                G       I
         */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(6);
        root.right.left.left.left = new TreeNode(7);
        root.right.right.left = new TreeNode(8);
        root.right.right.left.right = new TreeNode(9);
        root.right.right.right = new TreeNode(10);

        List<List<Integer>> expected = List.of(List.of(1), List.of(2, 3), List.of(4, 5), List.of(6, 8, 10), List.of(7, 9));

        assertEquals(expected.toString(), binaryTreeLevelOrder.levelOrder(root)
                .toString());

    }
}