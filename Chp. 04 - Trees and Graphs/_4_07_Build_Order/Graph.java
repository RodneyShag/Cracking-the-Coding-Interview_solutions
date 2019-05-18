package _4_07_Build_Order;

import java.util.*;

public class Graph { // public variables for convenience
    public List<Node> nodes = new ArrayList<>();
    public Map<String, Node> map = new HashMap<>();

    public void addDirectedEdge(String s1, String s2) {
        Node source = map.get(s1);
        Node destination = map.get(s2);
        source.addDirectedNeighbor(destination);
    }

    public void addNode(String str) {
        Node node = new Node(str);
        nodes.add(node);
        map.put(str, node);
    }
}
