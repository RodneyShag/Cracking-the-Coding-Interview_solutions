package chapter04;

import java.util.HashSet;

/* Here, our graph is implemented in a way not learned in CS225...
 * The edges themselves are saved in the GraphNodes as opposed to in their own structure.
 */
public class GraphNode {
	int data;
	boolean visited;                      // crucial for BFS, DFS
	private HashSet<GraphNode> neighbors;
	
	/* Constructor */
	public GraphNode(int data){
		this.data = data;
		visited   = false;
		neighbors = new HashSet<>();
	}
	
	public void visit(){
		visited = true;
	}
	
	public HashSet<GraphNode> getNeighbors(){
		return neighbors;
	}
	
	/* Assuming undirected graph */
	public void addNeighbor(GraphNode neighbor){
		neighbors.add(neighbor);
		neighbor.neighbors.add(this);
	}
}
