package _4_07_Build_Order;

import java.util.Arrays;
import java.util.List;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 4.7: Build Order\n");
        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        Node d = new Node('d');
        Node e = new Node('e');
        Node f = new Node('f');
        a.addDirectedNeighbor(d);
        f.addDirectedNeighbor(b);
        b.addDirectedNeighbor(d);
        f.addDirectedNeighbor(a);
        d.addDirectedNeighbor(c);
        List<Node> nodes = Arrays.asList(a, b, c, d, e, f);

        try {
            System.out.println(BuildOrder.topologicalSort(nodes));
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }
}
