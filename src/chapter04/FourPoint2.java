package chapter04;

import java.util.ArrayDeque;

public class FourPoint2 {
	/* We do BFS from start node to see if we arrive at end node */
	public static boolean routeExists(GraphNode start, GraphNode end){
		if (start == end) {
			return true;
		}
		
		ArrayDeque<GraphNode> deque = new ArrayDeque<>(); // use deque as a queue
		start.visit();
		deque.add(start);
		
		while (!deque.isEmpty()) {
			GraphNode curr = deque.remove();
			if (curr == end) {
				return true;
			}
			for (GraphNode neighbor : curr.getNeighbors()) {
				if ( ! neighbor.visited) {
					neighbor.visit();
					deque.add(neighbor);
				}
			}
		}
		return false;
	}
	
	// Can also do bi-directional BFS to improve runtime
}
