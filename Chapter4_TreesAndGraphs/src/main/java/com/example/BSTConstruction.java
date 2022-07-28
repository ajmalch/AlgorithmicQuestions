package com.example;

public class BSTConstruction {

    private BSTConstruction left;
    private BSTConstruction right;
    private int val;

    public BSTConstruction(int val) {
        this.val = val;
    }

    public BSTConstruction getLeft() {
        return left;
    }

    public BSTConstruction getRight() {
        return right;
    }

    public int getVal() {
        return val;
    }

    public BSTConstruction insert(int value) {
        insertRecursive(value);
        return this;
    }

    private void insertRecursive(int value) {

        if (value < this.val) {
            if (this.left == null) {
                this.left = new BSTConstruction(value);
            } else {
                this.left.insertRecursive(value);
            }
        } else {
            if (this.right == null) {
                this.right = new BSTConstruction(value);
            } else {
                this.right.insertRecursive(value);
            }
        }

    }


    public boolean contains(int value) {

        return searchRecursive(value);

    }

    private boolean searchRecursive(int value) {

        if (this.val == value) {
            return true;
        } else if (value < this.val) {
            if (this.left == null)
                return false;
            return this.left.searchRecursive(value);
        } else {
            if (this.right == null)
                return false;
            return this.right.searchRecursive(value);
        }

    }

    public BSTConstruction remove(int value) {
        remove(null, value);
        return this;
    }

    private void remove(BSTConstruction parentNode, int value) {
        BSTConstruction currentNode = this;
        while (currentNode != null) {
            if (value < currentNode.val) {
                parentNode = currentNode;
                currentNode = currentNode.left;
            } else if (value > currentNode.val) {
                parentNode = currentNode;
                currentNode = currentNode.right;
            } else {
                if (currentNode.left != null && currentNode.right != null) {
                    currentNode.val = currentNode.right.getMinValue();
                    currentNode.right.remove(currentNode, currentNode.val);
                } else if (parentNode == null) {

                    if (currentNode.left != null) {
                        currentNode.val = currentNode.left.val;
                        currentNode.right = currentNode.left.right;
                        currentNode.left = currentNode.left.left;
                    } else if (currentNode.right != null) {
                        currentNode.val = currentNode.right.val;
                        currentNode.left = currentNode.right.left;
                        currentNode.right = currentNode.right.right;
                    } else {
                    }

                } else if (parentNode.left == currentNode) {
                    parentNode.left = currentNode.left != null ? currentNode.left : currentNode.right;
                } else if (parentNode.right == currentNode) {
                    parentNode.right = currentNode.left != null ? currentNode.left : currentNode.right;
                }
                break;
            }

        }

    }

    private int getMinValue() {
        if (left == null) {
            return val;
        } else {
            return left.getMinValue();
        }
    }
}




