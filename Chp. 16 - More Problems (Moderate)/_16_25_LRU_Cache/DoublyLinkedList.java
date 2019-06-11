package _16_25_LRU_Cache;

public class DoublyLinkedList {
    private Node head = new Node(0, "dummy");
    private Node tail = new Node(0, "dummy");

    public DoublyLinkedList() {
        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(Node n) {
        if (n == null) {
            return;
        }
        n.prev = head;
        n.next = head.next;
        head.next.prev = n;
        head.next = n;
    }

    public void remove(Node n) { // Assumes 'n' is in this list
        if (n == null || n.prev == null || n.next == null) {
            return;
        }
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    public Node getFirst() {
        if (head.next == tail) {
            return null; // list has 0 Nodes
        }
        return head.next;
    }

    public Node getLast() {
        if (head.next == tail) {
            return null; // list has 0 Nodes
        }
        return tail.prev;
    }
}
