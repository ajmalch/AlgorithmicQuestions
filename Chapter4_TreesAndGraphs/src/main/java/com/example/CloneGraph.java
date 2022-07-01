package com.example;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Given a reference of a node in a connected undirected graph.
 * <p>
 * Return a deep copy (clone) of the graph.
 * <p>
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 */
public class CloneGraph {

    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }


        HashMap<Node, Node> visited = new HashMap<>();
        visited.put(node, new Node(node.val));

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {

            Node current = queue.remove();

            for (Node neighbor : current.neighbors) {

                if (!visited.containsKey(neighbor)) {

                    visited.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }

                visited.get(current).neighbors.add(visited.get(neighbor));

            }

        }

        return visited.get(node);

    }
}
