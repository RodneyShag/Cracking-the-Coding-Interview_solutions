package _2_2_Return_Kth_to_Last;

import common.Node;
import common.ListFunctions;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 2.2: Return Kth to Last\n");
        System.out.println("we count starting from 1 (not 0), so last element is element #1\n");
        test(new Node(new int[]{ 5, 6, 4, 9 }), 2);
        test(new Node(new int[]{ 6, 2, 1, 4 }), 5);
    }

    private static void test(Node head, int k) {
        ListFunctions.printList(head);
        Node m = ReturnKthToLast.kthLast(head, k);
        if (m != null) {
            System.out.format("Element %d from end = %d%n%n", k, m.data);
        } else {
            System.out.format("k = %d is outside of range%n", k);
        }
    }
}
