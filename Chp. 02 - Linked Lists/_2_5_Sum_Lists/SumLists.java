package _2_5_Sum_Lists;

import common.Node;
import java.util.Stack;

public class SumLists {
    public static Node addReverseOrder(Node m, Node n) {
        if (m == null) {
            return m;
        } else if (n == null) {
            return n;
        }
        int carry = 0;
        Node dummy = new Node(0); // 1 Node before the actual head of list
        Node tail = dummy;
        while (m != null || n != null || carry != 0) {
            int value = carry;
            if (m != null) {
                value += m.data;
                m = m.next;
            }
            if (n != null) {
                value += n.data;
                n = n.next;
            }
            int digit = value % 10;
            carry = value / 10;
            tail.next = new Node(digit);
            tail = tail.next;
        }
        return dummy.next;
    }

    public static Node addForwardOrder(Node m, Node n) {
        if (m == null) {
            return m;
        } else if (n == null) {
            return n;
        }

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (m != null) {
            stack1.push(m.data);
            m = m.next;
        }
        while (n != null) {
            stack2.push(n.data);
            n = n.next;
        }

        int carry = 0;
        Node dummy = new Node(0); // 1 Node before the actual head of list
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int value = carry;
            if (!stack1.isEmpty()) {
                value += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                value += stack2.pop();
            }
            int digit = value % 10;
            carry = value / 10;
            Node head = new Node(digit);
            head.next = dummy.next; 
            dummy.next = head;
        }
        return dummy.next;
    }
}

// Time/Space Complexity for both solutions
//
//  Time Complexity: O(m + n)
// Space Complexity: O(m + n)
