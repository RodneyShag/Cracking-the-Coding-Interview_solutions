// github.com/RodneyShag

package _2_6_Palindrome;

import common.Node;
import common.ListFunctions;

public class Palindrome {
    public static boolean palindrome(Node head) {
        if (head == null) {
            return false; // depends on our definition of a palindrome.
        }

        // Reverse 2nd half of list
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) { // for lists with odd # of Nodes
            slow = slow.next;
        }
        Node slowCenter = ListFunctions.reverseListIterative(slow);

        // compare 1st half of list to 2nd half
        Node slowFront = head;
        ListFunctions.printList(slowFront);
        ListFunctions.printList(slowCenter);
        
        while (slowCenter != null) {
            if (slowCenter.data != slowFront.data) {
                return false;
            }
            slowFront = slowFront.next;
            slowCenter = slowCenter.next;
        }
        return true;
    }
}

//  Time Complexity: O(n)
// Space Complexity: O(1)


// Alternate solution - O(n) time, O(n) space
//
// 1. Save 1st half of list in stack
// 2. Compare 2nd half of list to 1st half of list


// Alternate solution - O(n) time, O(n) space
//
// 1. Deep copy list.
// 2. Reverse it.
// 3. Compare it to original.
