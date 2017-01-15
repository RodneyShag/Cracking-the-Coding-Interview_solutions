package chapter4;
//import java.util.LinkedList;
/***********************************************************************************************/
/******** THIS IS PSEUDOCODE (which I commented out so no compiler errors***********************/
/***********************************************************************************************/
//Notice we use LinkedList instead of ArrayList cuz we're often removing 1st element

public class FourPoint2 {
	/* Will employ standard BFS */
	/* For "Graph", we have "getNodes()".  For "Node", we have "getAdjacent()" and "visit() */

/*
	public static boolean routeExists(Graph g, Node start, Node end){
		LinkedList<Node> queue = new LinkedList<Node>();	//couldn't create a "Queue" since Queue is an INTERFACE in Java. "LinkedList" implements this interface
		start.visit();
		while (!queue.isEmpty()){
			Node offQueue = queue.removeFirst();
			for (Node n : offQueue.getAdjacent()){
				if (!n.visited){
					if (n == end)
						return true;
					n.visit();
					queue.add(n);
				}
			}
		}
		return false;
	}
*/
}
