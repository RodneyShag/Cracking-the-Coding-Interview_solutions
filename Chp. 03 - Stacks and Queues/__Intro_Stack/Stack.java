package __Intro_Stack;

import common.Node;

public class Stack {
    private Node top = null;

    public void push(int data) {
        Node n = new Node(data);
        n.next = top;
        top = n;
    }

    public Node pop() {
        if (top == null) {
            return null;
        }
        Node n = top;
        top = top.next;
        n.next = null; // rips off the node from the Stack
        return n;
    }

    public Node peek() {
        return top;
    }
}

//  Time Complexity: O(1) for push(), pop(), peek().
// Space Complexity: O(1) for push(), pop(), peek(). O(1) to store each Node permanently.
