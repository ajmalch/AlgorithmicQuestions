package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class BinaryTreePathsTest {

    private final BinaryTreePaths binaryTreePaths = new BinaryTreePaths();

    @Test
    void binaryTreePathsTest() {
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


        final List<String> paths = binaryTreePaths.binaryTreePaths(root);
        Assertions.assertEquals(4, paths.size());
        Assertions.assertTrue(paths
                .containsAll(List.of("1->2", "1->3->4->6->7", "1->3->5->8->9", "1->3->5->10")));

    }
}