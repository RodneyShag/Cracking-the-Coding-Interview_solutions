package common;

import java.util.ArrayList;

// - Here, our graph is implemented somewhat like a Graph "Adjacency List" like in CS 225.
//      - Edges are not directly stored. Instead, a node's neighbors are saved in an ArrayList

public class GraphNode {
	public int data;
	public boolean visited; // needed for BFS, DFS
	private ArrayList<GraphNode> neighbors; // could alternatively use a HashSet (and give nodes unique IDs)
	
	/* Constructor */
	public GraphNode(int data) {
		this.data = data;
		visited   = false;
		neighbors = new ArrayList<>();
	}
	
	public void visit() {
		visited = true;
	}
	
	public ArrayList<GraphNode> getNeighbors() {
		return neighbors;
	}
	
	public void addNeighbor(GraphNode neighbor) {
		neighbors.add(neighbor);
		neighbor.neighbors.add(this);
	}
	
	public void addDirectedNeighbor(GraphNode neighbor) {
		neighbors.add(neighbor);
	}
}
