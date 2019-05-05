package _16_25_LRU_Cache;

public class DoublyLinkedList {
    Node head = null;
    Node tail = null;

    void addFirst(Node n) {
        if (head == null) {
            head = n;
            tail = n;
        } else {
            n.next = head;
            head.prev = n;
            head = n;
        }
    }
    
    void removeLast() {
    	removeNode(tail);
//        if (tail == null) {
//            return null;
//        } 
//        if (head == tail) { // only 1 Node in List
//            Node n = tail;
//            head = null;
//            tail = null;
//            return n;
//        } else {
//            Node n = tail;
//            tail = n.prev;
//            tail.next = null;
//            n.prev = null;
//            return n;
//        }
    }
    
    void removeNode(Node n) {
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
}
