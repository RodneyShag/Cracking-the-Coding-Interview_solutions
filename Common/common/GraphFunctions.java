package common;

import java.util.ArrayDeque;

public class GraphFunctions {
	
	public static void connectNodes(GraphNode node1, GraphNode node2) {
		node1.addNeighbor(node2);
		node2.addNeighbor(node1);
	}
	
	/* I do this recursively. Can alternatively do it like BFS (below) by using a Stack instead of a Queue. */
	public static void DFS(GraphNode node, int data) {
		if (node == null) {
			return;
		}
		
		if (node.data == data) {
			System.out.println("DFS found the GraphNode with desired data: " + node.data);
			return; // although we return, the DFS search keeps going in this implementation
		}
		
		for (GraphNode neighbor : node.getNeighbors()) {
			if (!neighbor.visited) {
				neighbor.visit(); // crucial step
				DFS(neighbor, data);
			}
		}
	}
	
	// Don't forget:
	//   1) Use a Queue
	//   2) .visit() a node before we add it to deque (to avoid duplicates on deque)
	public static void BFS(GraphNode node, int data) {
		if (node == null) {
			return;
		}
		
		ArrayDeque<GraphNode> deque = new ArrayDeque<>(); // use deque as a queue
		node.visit();
		deque.add(node);
		
		while (!deque.isEmpty()) {
			GraphNode curr = deque.removeFirst();

			if (curr.data == data) {
				System.out.println("BFS found the GraphNode with desired data: " + curr.data);
				return;
			}
			
			for (GraphNode neighbor : curr.getNeighbors()) {
				if (!neighbor.visited) {
					neighbor.visit(); // visit node BEFORE adding it to deque instead of when we take it off (to avoid duplicates on queue)
					deque.addLast(neighbor);
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
