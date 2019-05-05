package _16_25_LRU_Cache;

import java.util.Map;
import java.util.HashMap;

// - Excellent explanation in Cracking the Coding Interview, 6th Edition solutions

// FAQ
//
// Question: Why have our Node contain both key and value?
// Answer: Because when we remove from end of Linked List, the Node's key is used
//         to find the Node in the HashMap (to remove the node there as well)

class LRUCache {
    private int maxSize;
    private Map<Integer, Node> map; // gives us constant access to Nodes
    private DoublyLinkedList dll;   // used to keep track of "freshness" of Nodes
    
    public LRUCache(int maxSize) {
        this.maxSize = maxSize;
        map = new HashMap<>();
        dll = new DoublyLinkedList();
    }

    public void add(Integer key, Node value) {
        if (map.containsKey(key)) {
            get(key);
        } else {
            if (map.size() == maxSize) {
            	Node n = dll.tail;
                dll.removeLast();
                map.remove(n.key);
            }
            map.put(key, value);
            dll.addFirst(value);
        }
    }

    public Node get(Integer key) {
    	Node n = map.get(key);

    	// Update Freshness
    	if (n.prev != null) {
            n.prev.next = n.next;
        }
        if (n.next != null) {
            n.next.prev = n.prev;
        }
        dll.addFirst(n);

        return n;
    }

    public DoublyLinkedList getItems() {
        return dll;
    }
}
