package _2_5_Sum_Lists;

import common.Node;
import common.ListFunctions;

//  Time Complexity: O(n + m)
// Space Complexity: O(n + m)

public class SumLists {
    /* Reverse Order: Iterative solution */
    public static Node addReverseOrder(Node n, Node m) {
        if (n == null) {
            return m;
        } else if (m == null) {
            return n;
        }
        int carry = 0;
        Node head = null;
        Node tail = null;
        while (n != null || m != null || carry != 0) {
            int value = carry;
            if (n != null) {
                value += n.data;
                n = n.next;
            }
            if (m != null) {
                value += m.data;
                m = m.next;
            }
            int digit = value % 10;
            carry = value / 10;
            Node toAdd = new Node(digit);
            if (head == null) {
                head = toAdd;
                tail = toAdd;
            } else {
                tail.next = toAdd;
                tail = toAdd;
            }
        }
        return head;
    }

    /* Forward Order: Recursive solution */
    public static Node addForwardOrder(Node n, Node m) {
        /* Pad the shorter list with 0's */
        int sizeN = ListFunctions.calculateSize(n);
        int sizeM = ListFunctions.calculateSize(m);
        if (sizeN > sizeM) {
            int numberOfZerosToInsert = sizeN - sizeM;
            for (int i = 0; i < numberOfZerosToInsert; i++) {
                m = ListFunctions.insertInFront(m, 0);
            }
        } else if (sizeM > sizeN) {
            int numberOfZerosToInsert = sizeM - sizeN;
            for (int i = 0; i < numberOfZerosToInsert; i++) {
                n = ListFunctions.insertInFront(n, 0);
            }
        }

        /* Do the addition */
        Pair result = addForwardOrderHelper(n, m);

        /* Account for the carry if necessary */
        if (result.carry == 0) {
            return result.node;
        } else {
            Node head = new Node(result.carry);
            head.next = result.node;
            return head;
        }
    }

    private static Pair addForwardOrderHelper(Node n, Node m) {
        // Either both "n" and "m" are null, or neither are null
        if (n == null) {
            return new Pair(null, 0);
        }

        Pair rest = addForwardOrderHelper(n.next, m.next);
        int value = n.data + m.data + rest.carry;

        int digit = value % 10;
        int carry = value / 10;

        Node head = new Node(digit);
        head.next = rest.node;
        return new Pair(head, carry);
    }
}
