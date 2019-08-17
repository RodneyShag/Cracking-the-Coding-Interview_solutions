package __Intro_Queue;

import common.Node;

public class Queue {
    private Node head = null;
    private Node tail = null;

    public void add(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }

    public Node remove() {
        if (head == null) {
            return null;
        }
        Node front = head;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        front.next = null; // rips the Node from the Queue
        return front;
    }

    public Node peek() {
        return head;
    }
}

//  Time Complexity: O(1) for add(), remove(), peek().
// Space Complexity: O(1) for add(), remove(), peek(). O(1) to store each Node permanently.
