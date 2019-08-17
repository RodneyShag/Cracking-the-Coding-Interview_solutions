package _4_01_Route_Between_Nodes;

import java.util.*;
import common.GraphNode;

// Algorithm: run BFS from start node and see if we arrive at end node

public class RouteBetweenNodes {
    public static boolean routeExists(GraphNode start, GraphNode end) {
        if (start == end) {
            return true;
        }

        Deque<GraphNode> deque = new ArrayDeque<>(); // use deque as a queue
        start.visit();
        deque.add(start);

        while (!deque.isEmpty()) {
            GraphNode curr = deque.remove();
            if (curr == end) {
                return true;
            }
            for (GraphNode neighbor : curr.getNeighbors()) {
                if (!neighbor.visited) {
                    neighbor.visit();
                    deque.add(neighbor);
                }
            }
        }
        return false;
    }
}

// Improvement: If this was an undirected graph, we could do bi-directional BFS to improve runtime.
