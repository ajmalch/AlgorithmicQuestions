package com.example;


/**
 * Given a binary tree, find the distance between two given nodes in the tree.
 * Distance between two nodes is the minimum number of edges to reach from one to another
 * If any of the node is missing in the tree, return -1;
 */

public class DistanceBetweenNodes {

    TreeNode result = null;


    public int distanceBetweenNodes(TreeNode root, TreeNode p, TreeNode q){
        TreeNode commonAncestor = lowestCommonAncestor(root, p, q);
        if (commonAncestor == null)
            return -1;

        int distanceToP = distanceToChildNode(commonAncestor, p, 0);
        int distanceToQ = distanceToChildNode(commonAncestor, q, 0);

        if(distanceToP !=-1 && distanceToQ != -1){
            return distanceToP+distanceToQ;
        }
        return -1;
    }

    private int distanceToChildNode(TreeNode parent, TreeNode node, int distance ) {
        if(node.equals(parent))
            return distance;
        if(parent == null)
            return -1;
        final int d = distanceToChildNode(parent.left, node, distance + 1);
        if(d != -1)
            return d;
        return  distanceToChildNode(parent.right, node, distance + 1);

    }


    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traverse(root, p, q);
        return result;
    }

    private boolean traverse(TreeNode node, TreeNode p, TreeNode q) {

        if (node == null || result != null) {
            return false;
        }

        int left = traverse(node.left, p, q) ? 1 : 0;
        int right = traverse(node.right, p, q) ? 1 : 0;

        int val = node.equals(p) || node.equals(q) ? 1 : 0;

        if (left + right + val > 1)
            result = node;

        return left + right + val > 0;

    }


}


