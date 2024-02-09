package com.example;

import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 * <p>
 * A leaf is a node with no children.
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> paths = new LinkedList<>();
        traverseTree(root, "", paths);
        return paths;
    }

    private void traverseTree(TreeNode node, String path, List<String> paths) {

        if (node != null) {
            path += String.valueOf(node.val);
            if (node.left == null && node.right == null) {
                paths.add(path);
            } else {
                path += "->";
                traverseTree(node.left, path, paths);
                traverseTree(node.right, path, paths);
            }

        }

    }
}
