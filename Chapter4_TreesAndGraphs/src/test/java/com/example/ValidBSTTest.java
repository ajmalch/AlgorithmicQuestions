package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidBSTTest {

    ValidBST validBST = new ValidBST();

    @Test
    void validBSTTest() {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.right = new TreeNode(5);

        assertTrue(validBST.isValidBST(root));
        assertFalse(validBST.isValidBSTUnique(root));

    }

    @Test
    void validBSTTest2() {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.right = new TreeNode(10);

        assertFalse(validBST.isValidBST(root));

    }
}