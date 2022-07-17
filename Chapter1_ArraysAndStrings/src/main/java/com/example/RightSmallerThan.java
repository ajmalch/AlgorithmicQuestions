package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a function that takes in an array of integers and returns an array of same length,
 * where each element in output array corresponds to the number of integers of the relevant index and
 * that are strictly smaller than the integer at that index
 * <p>
 * In other words value of output[i] represents the number of integers that are to the right of i and that are strictly
 * smaller that input[i]
 * <p>
 * sample input array = [8,5,11,-1,3,4,2]
 * sample output = [5,4,4,0,1,1,0]
 */

public class RightSmallerThan {


    public List<Integer> rightSmallerThan(List<Integer> array) {
        List<Integer> result = new ArrayList<>(array);

        SpecialBST specialBST = null;
        for (int i = array.size() - 1; i >= 0; i--) {

            if (specialBST == null) {
                specialBST = new SpecialBST(array.get(i));
                result.set(i, 0);
            } else {
                SpecialBST node = specialBST;
                int numsSmallerAtInsertTime = 0;
                while (node != null) {
                    final Integer currValue = array.get(i);
                    if (currValue < node.getVal()) {
                        node.setLeftSubTreeSize(node.getLeftSubTreeSize() + 1);
                        if (node.getLeft() == null) {
                            node.setLeft(new SpecialBST(currValue));
                            result.set(i, numsSmallerAtInsertTime);
                            node = null;
                        } else {
                            node = node.getLeft();
                        }
                    } else {
                        if (currValue > node.getVal()) {
                            numsSmallerAtInsertTime = numsSmallerAtInsertTime + node.getLeftSubTreeSize() + 1;
                        } else {
                            numsSmallerAtInsertTime = numsSmallerAtInsertTime + node.getLeftSubTreeSize();
                        }
                        if (node.getRight() == null) {
                            node.setRight(new SpecialBST(currValue));
                            result.set(i, numsSmallerAtInsertTime);
                            node = null;
                        } else {
                            node = node.getRight();
                        }
                    }
                }
            }


        }

        return result;
    }


}


class SpecialBST {

    private final int val;
    private int leftSubTreeSize;
    private SpecialBST left;
    private SpecialBST right;

    public SpecialBST(int val) {
        this.val = val;
        leftSubTreeSize = 0;
        left = null;
        right = null;
    }

    public int getVal() {
        return val;
    }

    public int getLeftSubTreeSize() {
        return leftSubTreeSize;
    }

    public void setLeftSubTreeSize(int leftSubTreeSize) {
        this.leftSubTreeSize = leftSubTreeSize;
    }

    public SpecialBST getLeft() {
        return left;
    }

    public void setLeft(SpecialBST left) {
        this.left = left;
    }

    public SpecialBST getRight() {
        return right;
    }

    public void setRight(SpecialBST right) {
        this.right = right;
    }
}
