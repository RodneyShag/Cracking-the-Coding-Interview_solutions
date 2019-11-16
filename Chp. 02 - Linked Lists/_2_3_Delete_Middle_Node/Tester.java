// github.com/RodneyShag

package _2_3_Delete_Middle_Node;

import common.Node;
import common.ListFunctions;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 2.3: Delete Middle Node");
        test(new Node(new int[]{ 6, 7, 8, 9 }));
        test(new Node(new int[]{ 6, 7, 8, 9, 10 }));
    }

    private static void test(Node head) {
        System.out.println();
        ListFunctions.printList(head);
        DeleteMiddleNode.deleteMid(head.next.next);
        ListFunctions.printList(head);
    }
}
