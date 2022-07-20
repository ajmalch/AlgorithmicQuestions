package com.example;


/*
You will be given of tree with nodes as Strings (of any printable letters).
Each node will have 0..n children
Write two methods to serialize tree to string and deserialize that string back to original tree
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.List.of;

public class TreeSerialization {


    public static void main(String[] args) {

        Tree sample1 = new Tree("Ajmal");
        Tree sample2 = new Tree("Shadiya");
        Tree sample3 = new Tree("Ajmal");

        sample3.setChildren(of(new Tree("Mat"), new Tree("Sam")));
        sample2.setChildren(of(new Tree("Erwin"), sample3, new Tree("Frank")));
        sample1.setChildren(of(sample2, new Tree("Maliha")));

        System.out.println(sample1);
        System.out.println(serializeTree(sample1));
        System.out.println(deserializeTree(serializeTree(sample1)));

    }

    static String serializeTree(Tree tree) {

//        String result = "Tree{";
//
//        result += "root='" + tree.getRoot() + "'";
//
//        result += ", children=";
//
//        Queue<Tree> treeQueue = new LinkedBlockingDeque<>();
//
//        if (tree.getChildren() != null) {
//            result += "[";
//            tree.getChildren()
//                    .forEach(treeQueue::add);
//        } else {
//            result += "null";
//        }
//
//
//        while (!treeQueue.isEmpty()) {
//
//            if (treeQueue.size() == 1) {
//                result += serializeTree(treeQueue.remove()) + "]";
//            } else {
//
//                result += serializeTree(treeQueue.remove()) + ", ";
//            }
//
//        }
//
//        result += "}";
//
//        return result;

        return rSerialize(tree, "");
    }


    private static String rSerialize(Tree node, String s) {

        if (node == null) {
            return s + "null,";
        }
        s += node.getRoot() + ",";

        for (Tree child : node.getChildren()) {
            s += rSerialize(child, s);
        }

        return s;

    }

    static Tree deserializeTree(String input) {


//        String[] tokens = input.split("\\{");

        String currentNode;
        List<Tree> children = null;
        if (input.indexOf("\\{") == -1) {
            currentNode = input;
        } else {

            currentNode = input.substring(0, input.indexOf("\\{"));
            String[] split = input.substring(input.indexOf("\\{"), input.length())
                    .split(",");
            children = Arrays.stream(split)
                    .map(Tree::new)
                    .collect(Collectors.toList());
        }


        Tree tree = new Tree(currentNode);

        tree.setChildren(children);

        return tree;

    }


}


class Tree {

    private final String root;
    private List<Tree> children;
    private Tree parent;

    public Tree(String root, Tree parent) {
        this.root = root;
        this.parent = parent;
    }

    public Tree(String root) {
        this.root = root;
    }

    public Tree getParent() {
        return parent;
    }

    public void setParent(Tree parent) {
        this.parent = parent;
    }

    public String getRoot() {
        return root;
    }


    public List<Tree> getChildren() {
        return children;
    }

    public void setChildren(List<Tree> children) {
        if (children != null) {
            this.children = children;
            children.forEach(c -> c.setParent(this));
        }

    }

    @Override
    public String toString() {
        return "Tree{" +
                "root='" + root + '\'' +
                ", children=" + children +
                '}';
    }
}