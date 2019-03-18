package _2_7_Intersection;

import common.Node;

// Create a pointer that iterates through a list. When it's at the end
// of the list, have it jump to the beginning of the other list. Create
// 2 of these pointers, pointing to 2 different list heads. The pointers  
// will collide at the merge point after 1 or 2 passes. If they don't, 
// then there is no merge point.

public class Intersection {
    public static Integer findMergeNode(Node headA, Node headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Node currA = headA;
        Node currB = headB;

        int jumps = 0;
        while (currA != currB) {
            if (currA.next == null) {
                currA = headB;
                jumps++;
            } else {
                currA = currA.next;
            }

            if (currB.next == null) {
                currB = headA;
                jumps++;
            } else {
                currB = currB.next;
            }
            if (jumps > 2) {
                return null; // they don't intersect
            }
        }
        return currA.data;
    }
}

//  Time Complexity: O(n)
// Space Complexity: O(1)
