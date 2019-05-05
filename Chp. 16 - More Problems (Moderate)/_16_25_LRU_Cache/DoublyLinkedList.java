package _16_25_LRU_Cache;

public class DoublyLinkedList {
    private Node head = null;
    private Node tail = null;

    public void addFirst(Node n) {
        if (head == null) {
            head = n;
            tail = n;
        } else {
            n.prev = null;
            n.next = head;
            head.prev = n;
            head = n;
        }
    }

    public void remove(Node n) { // Assumes "Node n" is in this list
        if (n == null) {
            return;
        }
        if (n.prev != null) {
            n.prev.next = n.next;
        }
        if (n.next != null) {
            n.next.prev = n.prev;
        }
        if (n == head) {
            head = n.next;
        }
        if (n == tail) {
            tail = n.prev;
        }
    }
    
    public void updateFreshness(Node n) { // Assumes "Node n" is in this list
        remove(n);
        addFirst(n);
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }
}
