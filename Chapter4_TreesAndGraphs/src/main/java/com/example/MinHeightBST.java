package com.example;

import java.util.List;

/**
 * Write a function that takes in a non-empty sorted array of distinct integers, construct BST from the integers and returns the root of the BST
 * The function should limit the height of BST
 */
public class MinHeightBST {

    //O(n) time
    public static BST minHeightBst(List<Integer> array) {
        // Write your code here.
        return minHeightBSTRecursive(array, 0, array.size() - 1);
    }


    private static BST minHeightBSTRecursive(List<Integer> array, int left, int right) {
        if (right < left) return null;
        int mid = left + (right - left) / 2;
        BST bst = new BST(array.get(mid));
        bst.left = minHeightBSTRecursive(array, left, mid - 1);
        bst.right = minHeightBSTRecursive(array, mid + 1, right);
        return bst;
    }


    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }
}
