package com.example;

import java.util.List;

public class BinaryTreeTraversals {

    public List<Integer> inOrderTraverse(TreeNode tree, List<Integer> array) {

        if (tree.left != null) {
            inOrderTraverse(tree.left, array);
        }
        array.add(tree.val);
        if (tree.right != null) {
            inOrderTraverse(tree.right, array);
        }

        return array;
    }

    public List<Integer> preOrderTraverse(TreeNode tree, List<Integer> array) {

        array.add(tree.val);
        if (tree.left != null) {
            preOrderTraverse(tree.left, array);
        }
        if (tree.right != null) {
            preOrderTraverse(tree.right, array);
        }

        return array;
    }

    public List<Integer> postOrderTraverse(TreeNode tree, List<Integer> array) {

        if (tree.left != null) {
            postOrderTraverse(tree.left, array);
        }
        if (tree.right != null) {
            postOrderTraverse(tree.right, array);
        }
        array.add(tree.val);
        return array;
    }

}

