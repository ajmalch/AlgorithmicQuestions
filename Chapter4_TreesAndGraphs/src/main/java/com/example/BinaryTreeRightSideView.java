package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 */
public class BinaryTreeRightSideView {

    private Map<Integer, Integer> map = new HashMap<>();

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        traverse(root, 0);

        for (int i = 0; i < map.size(); i++) {
            result.add(map.get(i));
        }

        return result;
    }

    public void traverse(TreeNode node, int level) {

        if (node == null)
            return;
        map.put(level, node.val);
        traverse(node.left, level + 1);
        traverse(node.right, level + 1);

    }

}
