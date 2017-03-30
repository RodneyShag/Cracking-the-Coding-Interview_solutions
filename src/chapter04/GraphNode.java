package chapter04;

import java.util.ArrayList;

/* - Here, our graph is implemented somewhat like a Graph "Adjacency List" like in CS 225.
 *      - Edges are not directly stored. Instead, a node's neighbors are saved in an ArrayList
 */
public class GraphNode {
	public int data;
	public boolean visited; // needed for BFS, DFS
	private ArrayList<GraphNode> neighbors;
	
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
	
	/* Assuming undirected graph */
	public void addNeighbor(GraphNode neighbor) {
		neighbors.add(neighbor);
		neighbor.neighbors.add(this);
	}
}
