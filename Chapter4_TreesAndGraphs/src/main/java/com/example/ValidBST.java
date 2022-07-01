package com.example;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * A valid BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class ValidBST {

    Integer prev;

    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inorder(root);
    }

    boolean inorder(TreeNode tree) {

        if (tree == null) return true;
        if (!inorder(tree.left)) return false;
        if (prev != null && tree.val <= prev) return false;
        prev = tree.val;
        return inorder(tree.right);

    }
}
