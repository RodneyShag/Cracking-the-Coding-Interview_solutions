// github.com/RodneyShag

package _4_07_Build_Order;

import java.util.*;

// From Jeff Erickson's Algorithms.pdf, Section 19.5 Topological Sort

public class BuildOrder {
    // Converts our inconveniently formatted input into a graph
    public static Deque<Node> topoSort(String[] projects, String[][] dependencies) throws Exception {
        Graph graph = new Graph();
        for (String project : projects) {
            graph.addNode(project);
        }
        for (String[] dependency : dependencies) {
            String source = dependency[0];
            String destination = dependency[1];
            graph.addDirectedEdge(source, destination);
        }
        return topoSort(graph);
    }

    private static Deque<Node> topoSort(Graph graph) throws Exception {
        Node source = new Node("Source");
        for (Node node : graph.nodes) {
            source.addDirectedNeighbor(node);
        }

        Deque<Node> result = new ArrayDeque<>();
        topoSortDFS(source, result);
        result.removeFirst(); // removes the source node we created
        return result;
    }

    private static void topoSortDFS(Node n, Deque<Node> result) throws Exception {
        n.status = Visited.ACTIVE;
        for (Node neighbor : n.neighbors) {
            if (neighbor.status == Visited.NEW) {
                topoSortDFS(neighbor, result);
            } else if (neighbor.status == Visited.ACTIVE) {
                throw new Exception("Not a Directed Acyclic Graph (DAG). Graph has a cycle.");
            }
        }
        n.status = Visited.DONE;
        result.addFirst(n);
    }
}

//  Time Complexity: O(n)
// Space Complexity: O(n) due to recursion
