package _4_07_Build_Order;

import java.util.List;
import java.util.ArrayDeque;

// From Jeff Erickson's Algorithms.pdf, Section 19.5 Topological Sort

public class BuildOrder {		
	public static ArrayDeque<Node> topologicalSort(List<Node> nodes) throws Exception {
		/* Create new "source" Node which has a directed edge to each node in our original graph */
		Node source = new Node('s');
		for (Node node : nodes) {
			source.addDirectedNeighbor(node);
		}
		
		ArrayDeque<Node> result = new ArrayDeque<>();
		topoSortDFS(source, result);
		result.removeFirst(); // removes the source node we created
		return result;
	}
	
	private static void topoSortDFS(Node n, ArrayDeque<Node> result) throws Exception {
		n.status = Visited.ACTIVE;
		for (Node neighbor : n.neighbors) {
			if (neighbor.status == Visited.NEW) {
				topoSortDFS(neighbor, result);
			} else if (neighbor.status == Visited.ACTIVE) {
				throw new Exception("Not a DAG");
			}
		}
		n.status = Visited.DONE;
		result.addFirst(n);
	}
}
