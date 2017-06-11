package _16_25_LRU_Cache;

public class Tester {
	public static void main(String[] args) {
		System.out.println("*** Test 16.25: LRU Cache\n");
		
		/* Create LRU Cache */
		LRUCache cache = new LRUCache();
		for (int i = 20; i >= 1; i--) {
			Item item = new Item("Item " + i);
			cache.add(item);
		}
		
		/* Access Item 4, and print cache items */
		cache.access("Item 4"); // should move it to head of cache
		for (Item item : cache.getItems()) {
			System.out.println(item);
		}
	}
}
