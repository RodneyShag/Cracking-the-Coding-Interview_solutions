// github.com/RodneyShag

package _2_4_Partition;

import common.Node;
import common.ListFunctions;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 2.4: Partition");
        test(new Node(new int[]{ 6, 3, 4, 8, 2 }), 5);
        test(new Node(new int[]{ 4, 8, 6, 7, 9, 2, 1 }), 3);
    }

    private static void test(Node head, int partitionValue) {
        System.out.print("\nOriginal List: ");
        ListFunctions.printList(head);
        System.out.print("Partition value: " + partitionValue + "\n");

        System.out.print("Solution 1: ");
        head = Partition.partition(head, partitionValue);
        ListFunctions.printList(head);

        System.out.print("Solution 2: ");
        head = Partition.partition2(head, partitionValue);
        ListFunctions.printList(head);
    }
}
