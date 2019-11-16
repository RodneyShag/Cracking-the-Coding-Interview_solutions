// github.com/RodneyShag

package _2_6_Palindrome;

import common.Node;
import common.ListFunctions;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 2.6: Palindrome\n");
        test(new Node(new int[]{ 1, 2, 3, 4 }));
        test(new Node(new int[]{ 1, 2, 3, 4, 3, 2, 1 }));
        test(new Node(new int[]{ 1, 2, 2, 1 }));
        test(new Node(new int[]{ 1, 2, 2, 1, 8, 2, 1 }));
    }

    private static void test(Node head) {
        ListFunctions.printList(head);
        System.out.println("Palindrome? " + Palindrome.palindrome(head) + "\n");
    }
}
