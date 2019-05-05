package _16_25_LRU_Cache;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 16.25: LRU Cache\n");

        /* Create LRU Cache */
        LRUCache cache = new LRUCache(7);
        for (int i = 20; i >= 1; i--) {
            cache.add(i, "Node " + i + " value");
        }

        /* Access Item 4, and print cache items */
        cache.remove(1);
        cache.getValue(4); // should move it to head of cache
        Node n = cache.getItems().getHead();
        while (n != null) {
        	System.out.println(n);
        	n = n.next;
        }
    }
}
