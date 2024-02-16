package com.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * You're given a Node class that has a name and an array of optional children
 * nodes. When put together, nodes form an acyclic tree-like structure.
 * Implement the breadthFirstSearch method on the Node class, which takes in an empty array, traverses the tree
 * using the Breadth-first Search approach (specifically navigating the tree from left to right),
 * stores all of the nodes' names in the input array, and returns it.
 */
public class BreadthFirstSearch {

    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {

            Queue<Node> queue = new LinkedList<>();
            queue.offer(this);
            while(!queue.isEmpty()){
                Node node =  queue.poll();
                array.add(node.name);
                for(Node child : node.children){
                    queue.offer(child);
                }
            }

            return array;
        }

        public void addChild(Node child) {
            children.add(child);
        }
    }

}
