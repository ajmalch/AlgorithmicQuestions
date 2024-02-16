package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DistanceBetweenNodesTest {

    DistanceBetweenNodes distanceBetweenNodes = new DistanceBetweenNodes();

    @Test
    void distanceBetweenNodes() {


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

        assertEquals(4, distanceBetweenNodes.distanceBetweenNodes(root, root.right.left.left, root.right.right.left));
    }
}