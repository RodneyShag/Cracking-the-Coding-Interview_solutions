package __Intro_BFS;

import common.GraphNode;
import common.GraphFunctions;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test BFS\n");
        GraphNode graphNode = GraphFunctions.createGraph();
        GraphFunctions.BFS(graphNode, 6); // searches for value 6
    }
}
