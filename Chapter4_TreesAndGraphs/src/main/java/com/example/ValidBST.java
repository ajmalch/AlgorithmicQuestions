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

    public boolean isValidBSTUnique(TreeNode root) {
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


    /**
     * If BST allows duplicate elements, BST characteristics changes as
     * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
     *
     * @param tree input tree
     * @return if tree is valid BST or not
     */
    public boolean isValidBST(TreeNode tree) {
        // Write your code here.
        return traverse(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    private boolean traverse(TreeNode tree, int min, int max) {

        if (tree == null) return true;
        if (tree.val < min || tree.val >= max)
            return false;
        if (!traverse(tree.left, min, tree.val))
            return false;
        return traverse(tree.right, tree.val, max);
    }
}
