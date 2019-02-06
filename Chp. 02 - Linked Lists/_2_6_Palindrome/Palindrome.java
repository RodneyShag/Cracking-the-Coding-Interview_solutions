package _2_6_Palindrome;

import common.Node;
import common.ListFunctions;

import java.util.ArrayDeque;

public class Palindrome {
    public static boolean palindrome(Node head) {
        int size = ListFunctions.calculateSize(head);
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        Node curr = head;
        /* Save 1st half of list */
        for (int i = 0; i < size / 2; i++) {
            deque.push(curr.data);
            curr = curr.next;
        }
        /* If list had odd number of elements -> skip middle element */
        if (size % 2 == 1) {
            curr = curr.next;
        }
        /* Compare 2nd half of list to 1st half of list */
        while (curr != null) {
            if (deque.pop() != curr.data) {
                return false;
            }
            curr = curr.next;
        }
        return true;
    }

    // Alternate solution: Deep copy list. Reverse it. Compare it to original.
}
