package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(KthLargestBSTParamResolver.class)
class KthLargestBSTTest {

    @Test
    void findKthLargestValueInBstTest(KthLargestBST kthLargestBST) {

        TreeNode tree = new TreeNode(15);
        tree.left = new TreeNode(5);
        tree.left.left = new TreeNode(2);
        tree.left.left.left = new TreeNode(1);
        tree.left.left.right = new TreeNode(3);
        tree.left.right = new TreeNode(5);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(17);
        tree.right.right = new TreeNode(22);


        Assertions.assertEquals(17, kthLargestBST.findKthLargestValueInBst(tree, 3));


    }
}