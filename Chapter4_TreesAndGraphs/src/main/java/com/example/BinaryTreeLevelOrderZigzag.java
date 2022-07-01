package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree,
 * return the zigzag level order traversal of its nodes' values.
 * (i.e., from left to right, then right to left for the next level and alternate between).
 */
public class BinaryTreeLevelOrderZigzag {

    List<List<Integer>> levels = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        traverse(root, 0);
        return levels;
    }

    private void traverse(TreeNode node, int level) {

        if (node == null)
            return;
        if (levels.size() == level)
            levels.add(new ArrayList<>());
        if (level % 2 == 0)
            levels.get(level)
                    .add(node.val);
        else
            levels.get(level)
                    .add(0, node.val);
        traverse(node.left, level + 1);
        traverse(node.right, level + 1);


    }
}
