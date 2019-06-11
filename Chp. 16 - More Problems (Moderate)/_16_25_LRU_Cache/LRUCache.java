package _16_25_LRU_Cache;

import java.util.Map;
import java.util.HashMap;

// Excellent explanation in Cracking the Coding Interview, 6th Edition solutions

// FAQ
//
// Question: Why have our Node contain both key and value?
// Answer: Because when we remove from end of Linked List, the Node's key is used
//         to find the Node in the HashMap (to remove the node there as well)

public class LRUCache {
    private int maxSize;
    private Map<Integer, Node> map; // gives us O(1)-time access to Nodes
    private DoublyLinkedList dll;   // used to keep track of "freshness" of Nodes
    
    public LRUCache(int maxSize) {
        this.maxSize = (maxSize < 1) ? 1 : maxSize;
        map = new HashMap<>();
        dll = new DoublyLinkedList();
    }

    public void put(int key, String value) {
        remove(key); // If key already exists, we will overwrite it.
        if (map.size() >= maxSize) {
            remove(dll.getLast().key);
        }
        Node n = new Node(key, value);
        dll.addFirst(n);
        map.put(key, n);
    }

    public void remove(int key) {
        Node n = map.get(key);
        dll.remove(n);
        map.remove(key);
    }

    public String get(int key) {
        Node n = map.get(key);
        if (n == null) {
            return null;
        }
        if (n != dll.getFirst()) {
            updateFreshness(n);
        }
        return n.value;
    }

    private void updateFreshness(Node n) { // Assumes 'n' is in this list
        dll.remove(n);
        dll.addFirst(n);
    }

    public DoublyLinkedList getItems() { // added for testing
        return dll;
    }
}
