package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */
public class BinaryTreeLevelOrder {

    List<List<Integer>> levels = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        traverse(root, 0);
        return levels;
    }

    private void traverse(TreeNode node, int level) {
        if (node == null)
            return;
        if (levels.size() == level)
            levels.add(new ArrayList<>());

        levels.get(level)
                .add(node.val);
        traverse(node.left, level + 1);
        traverse(node.right, level + 1);
    }


}
