package com.example;

/**
 * Find Kth Largest Value In BST (
 * Write a function that takes in a Binary Search Tree (BST) and a positive integer k and returns the kth largest integer contained in the BST.
 * You can assume that thee will only be integer values in the BST and that k is less than or equal to the number of
 * nodes in the tree.
 * Also, for the purpose of this question, duplicate integers will be treated as distinct values.
 * In other words, the second largest value in a BST containing values
 * {5,
 * 7, 7] will be 7 -not
 * Each BST node an integer value, a left child node, and a right child node.
 * A node is said to be a valid BST node if and only if it satisfles the BST property:
 * its value is strictly greater than the values of every node to its left; its value is less than or equal to the values of every node to its right;
 * and its children nodes are either valid BST nodes themselves or None / null
 */
public class KthLargestBST {


    //O(h+k) Time, where h is the height of the tree
    public int findKthLargestValueInBst(TreeNode tree, int k) {
        // Write your code here.
        TreeInfo treeInfo = new TreeInfo(0, -1);
        traverse(tree, k, treeInfo);
        return treeInfo.latestVisitedNodeValue;

    }

    private void traverse(TreeNode node, int k, TreeInfo treeInfo) {

        if (node == null || treeInfo.numOfNodesVisited >= k)
            return;

        traverse(node.right, k, treeInfo);
        if (treeInfo.numOfNodesVisited < k) {
            treeInfo.latestVisitedNodeValue = node.val;
            treeInfo.numOfNodesVisited++;
            traverse(node.left, k, treeInfo);
        }

    }

    private static class TreeInfo {
        int numOfNodesVisited;
        int latestVisitedNodeValue;

        public TreeInfo(int numOfNodesVisited, int latestVisitedNodeValue) {
            this.numOfNodesVisited = numOfNodesVisited;
            this.latestVisitedNodeValue = latestVisitedNodeValue;
        }
    }

}
