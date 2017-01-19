package chapter4;

import java.util.Queue;
import java.util.LinkedList;

/* Finding if a route exists is simply BFS or DFS to see if we reach the desired node */
public class FourPoint2 {
	/* We do BFS from start node to see if we arrive at end node */
	public static boolean routeExists(GraphNode start, GraphNode end){
		if (start == end)
			return true;

		Queue<GraphNode> queue = new LinkedList<>();
		start.visit();
		queue.add(start);
		
		while ( ! queue.isEmpty()){
			GraphNode curr = queue.remove();
			if (curr == end)
				return true;
			for (GraphNode neighbor : curr.getNeighbors()){
				if ( ! neighbor.visited){
					neighbor.visit();
					queue.add(neighbor);
				}
			}
		}
		return false;
	}
}
