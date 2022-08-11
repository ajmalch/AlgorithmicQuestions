package com.example;

/**
 * Write a function which takes a binary tree and inverts it.
 * Inverting means for every node we will swap the left and right child in the result
 */
public class InvertBinaryTree {


    public void invertBinaryTree(TreeNode tree) {

        if (tree == null) {
            return;
        }

        TreeNode left = tree.left;
        tree.left = tree.right;
        tree.right = left;

        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);

    }

}
