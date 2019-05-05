package _16_25_LRU_Cache;

public class Node {
	int key;
    String value;
    Node next;
    Node prev;

    public Node(int k, String v) {
    	key = k;
        value = v;
        next = null;
        prev = null;
    }
    
    @Override
    public String toString() {
        return value;
    }
}
