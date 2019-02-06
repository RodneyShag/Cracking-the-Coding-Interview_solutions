package _2_8_Loop_Detection;

import common.Node;

// Algorithm:
//
// k = # of nodes from beginning of list to beginning of loop
// n = loop size
// When "slow" enters loop (after k nodes), "fast" is k nodes into the list.
// That means they will meet in "n - k" steps (Since they get 1 step closer each time).
// When they meet, "slow" is "n - k" steps into the loop, so "slow" will be at beginning of loop in "k" single steps.

public class LoopDetection {
    public static Node findBeginning(Node head) {
        Node slow = head; // moves at normal speed
        Node fast = head; // moves at double speed

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // they collided
                break;
            }
        }

        /*
         * Error Check - Detects if no loop was found. Don't forget this step!
         */
        if (fast == null || fast.next == null) {
            return null;
        }

        /*
         * Put "slow2" at head of list. Move "slow" and "slow2" 1 step at a
         * time. They collide at head of cycle
         */
        Node slow2 = head;
        while (slow2 != slow) {
            slow = slow.next;
            slow2 = slow2.next;
        }
        return slow;
    }
}
