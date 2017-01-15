package chapter4;

public class GraphNode {
	int data;
	boolean visited; //here so we can do BFS, DFS
	
	public void visit(){
		visited = true;
	}
}
