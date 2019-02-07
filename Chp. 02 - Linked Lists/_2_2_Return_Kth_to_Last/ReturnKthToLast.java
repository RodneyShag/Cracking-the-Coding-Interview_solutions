package _2_2_Return_Kth_to_Last;

import common.Node;
import common.ListFunctions;

// Algorithm: Just calculate the size of the SLL, then walk "size - k" elements into list

public class ReturnKthToLast {
    public static Node kthLast(Node n, int k) {
        int size = ListFunctions.calculateSize(n);
        if (k <= 0 || k > size) {
            return null;
        }
        for (int i = 0; i < size - k; i++) {
            n = n.next;
        }
        return n;
    }
}

//  Time Complexity: O(n)
// Space Complexity: O(1)
