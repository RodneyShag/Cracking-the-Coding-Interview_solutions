package _2_7_Intersection;

import common.Node;
import common.ListFunctions;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 2.7: Intersection\n");

        /* Test 1 */
        Node head1 = new Node(new int[]{ 3, 1, 5, 9 });
        Node head2 = new Node(new int[]{ 4, 6 });
        Node rest  = new Node(new int[]{ 7, 2, 1 });
        head1.appendToTail(rest);
        head2.appendToTail(rest);
        test(head1, head2);

        /* Test 2 */
        head1 = new Node(new int[]{ 3, 1, 5, 9, 7, 2, 1 });
        head2 = new Node(new int[]{ 4, 6, });
        test(head1, head2);
    }

    private static void test(Node head1, Node head2) {
        ListFunctions.printList(head1);
        ListFunctions.printList(head2);
        System.out.println("Intersection: " + Intersection.findMergeNode(head1, head2) + "\n");
    }
}
