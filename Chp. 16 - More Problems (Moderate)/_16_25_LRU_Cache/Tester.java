package _16_25_LRU_Cache;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 16.25: LRU Cache\n");

        /* Create LRU Cache */
        LRUCache cache = new LRUCache(7);
        for (int i = 20; i >= 1; i--) {
            Node node = new Node(i, "Node " + i + " value");
            cache.add(i, node);
        }

        /* Access Item 4, and print cache items */
        cache.get(4); // should move it to head of cache
        DoublyLinkedList items = cache.getItems();
        Node head = items.head;
        Node n = head;
        while (n != null) {
        	System.out.println(n);
        	n = n.next;
        }
    }
}
