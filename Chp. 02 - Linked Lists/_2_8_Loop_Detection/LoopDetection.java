// github.com/RodneyShag

package _2_8_Loop_Detection;

import common.Node;

// Algorithm:
//
// - k = # of nodes from beginning of list to beginning of loop
// - n = loop size
// - Create a 'slow' pointer (moves 1 step at a time) and a 'fast' pointer (moves 2 steps at a time) .
// - When 'slow' enters loop (after k nodes), 'fast' is k nodes into the list.
// - That means they will meet in 'n - k' steps (Since they get 1 step closer each time).
// - When they meet, 'slow' is 'n - k' steps into the loop, so 'slow' will be at beginning of loop in 'k' single steps.
// - Create 'slow2' at head of list, and move 'slow' and 'slow2' 1 step at a time, they will
//   collide in 'k' steps, at the head of cycle.

public class LoopDetection {
    public static Node findBeginning(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // they collided
                Node slow2 = head;
                while (slow2 != slow) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}

//  Time Complexity: O(n), where n is number of nodes in List.
// Space Complexity: O(1)
