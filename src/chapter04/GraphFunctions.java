package chapter04;

import java.util.Queue;
import java.util.LinkedList;

public class GraphFunctions {
	
	public static void connectNodes(GraphNode node1, GraphNode node2) {
		node1.addNeighbor(node2);
		node2.addNeighbor(node1);
	}
	
	/* I do this recursively. Can alternatively do it like BFS (below) but using a Stack instead of a Queue. */
	public static void DFS(GraphNode node, int data) {
		if (node == null) {
			return;
		}
		
		/* Process this node */
		node.visit();
		if (node.data == data) {
			System.out.println("DFS found the GraphNode with desired data: " + node.data);
			return; // although we return, the DFS search keeps going in this case
		}
		
		/* Recurse on necessary neighbors */
		for (GraphNode neighbor : node.getNeighbors()) {
			if ( ! neighbor.visited) {
				DFS(neighbor, data);
			}
		}
	}
	
	/* Don't forget:
	 * 1) Use a Queue
	 * 2) .visit() a node before we add it to queue
	 */
	public static void BFS(GraphNode node, int data) {
		if (node == null) {
			return;
		}
		
		Queue<GraphNode> queue = new LinkedList<>();
		node.visit();
		queue.add(node);
		
		while ( ! queue.isEmpty()) {
			GraphNode curr = queue.remove();

			if (curr.data == data) {
				System.out.println("BFS found the GraphNode with desired data: " + curr.data);
				return;
			}
			
			for (GraphNode neighbor : curr.getNeighbors()) {
				if ( ! neighbor.visited) {
					neighbor.visit();   // make sure to visit node BEFORE we put it on queue instead of when we take it off (to avoid duplicates on queue)
					queue.add(neighbor);
				}
			}
		}
	}
	
	/* Creates and returns this graph:
	 * 3 -- 1  -- 2 -- 5
	 *      |     |
	 *      4     6
	 */
	public static GraphNode createGraph() {
		GraphNode node1  = new GraphNode(1);
		node1.addNeighbor(new GraphNode(3));
		node1.addNeighbor(new GraphNode(4));
		GraphNode node2 = new GraphNode(2);
		node2.addNeighbor(new GraphNode(5));
		node2.addNeighbor(new GraphNode(6));
		GraphFunctions.connectNodes(node1, node2);
		return node1;
	}
}
