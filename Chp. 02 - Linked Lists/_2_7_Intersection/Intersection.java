// github.com/RodneyShag

package _2_7_Intersection;

import common.Node;

// Let "tail" refer to the first null at the end of the list.
// Create a pointer that iterates through a list.
// When it's at the tail of the list, have it jump to the beginning of the other list.
// Create 2 of these pointers, pointing to 2 different list heads.
// The pointers will collide at the merge point after 1 or 2 passes.
// If they don't collide after 2 passes, then they will both be null, and there is no merge point.

public class Intersection {
    public static Integer findMergeNode(Node headA, Node headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Node a = headA;
        Node b = headB;

        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a == null ? null: a.data;
    }
}

//  Time Complexity: O(n)
// Space Complexity: O(1)
