package _2_4_Partition;

import common.Node;

// Partitioning a SLL
//
// Solutions                                       Runtime   Preference
// ------------------------------------------------------------------------------------------
// 1) Quicksort's Partition function (adjusted)    O(n)      Favorite
// 2) Create 2 SLLs from SLL. Connect them.        O(n)      Use if swapping data not allowed

public class Partition {
    // Solution 1
    public static Node partition(Node head, int x) {
        Node curr = head;
        Node p = head;
        while (curr != null) {
            if (curr.data < x) {
                // Swap DATA values
                int temp = p.data;
                p.data = curr.data;
                curr.data = temp;

                p = p.next;
            }
            curr = curr.next;
        }
        return head;
    }

    // Solution 2
    public static Node partition2(Node n, int x) {
        Node head1 = null;
        Node head2 = null;
        Node tail1 = null; // to walk list1
        Node tail2 = null; // to walk list2

        while (n != null) {
            if (n.data < x) {
                if (head1 == null) {
                    head1 = n;
                    tail1 = n;
                } else {
                    tail1.next = n;
                    tail1 = n;
                }
            } else {
                if (head2 == null) {
                    head2 = n;
                    tail2 = n;
                } else {
                    tail2.next = n;
                    tail2 = n;
                }
            }
            n = n.next;
        }

        if (tail2 != null) {
            tail2.next = null;
        }

        if (head1 == null) {
            return head2;
        } else {
            tail1.next = head2;
            return head1;
        }
    }
}
