package com.example;

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * <p>
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 * <p>
 * The length of a path between two nodes is represented by the number of edges between them.
 */
public class BinaryTreeDiameter {

    private int diameter;

    public int diameterOfBinaryTree(TreeNode root) {

        diameter = 0;
        longestPath(root);
        return diameter;

    }

    private int longestPath(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int leftPath = longestPath(node.left);
        int rightPath = longestPath(node.right);

        diameter = Math.max(diameter, leftPath + rightPath);

        return Math.max(leftPath, rightPath) + 1;

    }

}
