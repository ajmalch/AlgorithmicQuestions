package com.example;

import java.util.*;

/**
 * Given the root of a binary tree, return the vertical order traversal of its nodes' values. (i.e., from top to bottom, column by column).
 */
public class BinaryTreeVerticalOrder {


    Map<Integer, Queue<int[]>> entryMap = new HashMap<>();

    /**
     * If two nodes are in the same row and column, return in any order.
     *
     * @param root
     * @return
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {

        List<List<Integer>> output = new ArrayList<>();
        if (root == null)
            return output;
        dfs(root, 0, 0);

        int columnMin = Collections.min(entryMap.keySet());
        int columnMax = Collections.max(entryMap.keySet());

        for (int column = columnMin; column <= columnMax; column++) {
            output.add(new ArrayList<>());
            while (!entryMap.get(column)
                    .isEmpty()) {
                int[] entry = entryMap.get(column)
                        .remove();
                output.get(output.size() - 1)
                        .add(entry[1]);
            }
        }

        // for(column=columnMin; column<=columnMax; column++){
        //     output.add(entryMap.get(column));
        // }


        return output;

    }

    private void dfs(TreeNode node, int column, int row) {

        if (node == null)
            return;
        entryMap.putIfAbsent(column, new PriorityQueue<>(Comparator.comparingInt(e -> e[0])));

        entryMap.get(column)
                .add(new int[]{row, node.val});
        dfs(node.left, column - 1, row + 1);
        dfs(node.right, column + 1, row + 1);

    }


    public List<List<Integer>> verticalOrderLeftToRight(TreeNode root) {

        List<List<Integer>> output = new ArrayList<>();
        if (root == null)
            return output;

        Map<Integer, List> entryMap = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();

        int column = 0;
        TreeNode node = root;
        queue.add(new Pair(node, column));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            node = pair.getKey();
            column = pair.getValue();

            if (node != null) {
                if (!entryMap.containsKey(column))
                    entryMap.put(column, new ArrayList<>());
                entryMap.get(column)
                        .add(node.val);

                queue.add(new Pair(node.left, column - 1));
                queue.add(new Pair(node.right, column + 1));
            }

        }

        int columnMin = Collections.min(entryMap.keySet());
        int columnMax = Collections.max(entryMap.keySet());

        for (column = columnMin; column <= columnMax; column++) {
            output.add(entryMap.get(column));
        }

        return output;

    }


}

class Pair<T, U> {

    private T key;
    private U value;


    public Pair(T key, U value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public U getValue() {
        return value;
    }
}