package _16_25_LRU_Cache;

import java.util.LinkedList;
import java.util.HashMap;

// I have to redo this problem to decrease runtime from O(n) to O(1) (like I did in an interview - code is saved)

// To read: http://www.geeksforgeeks.org/implement-lru-cache/

class LRUCache {
    private final int maxSize = 7;
    private LinkedList<Item> items = new LinkedList<>();
    private HashMap<String, Item> map = new HashMap<>();

    void add(Item item) {
        if (items.size() == maxSize) {
            map.remove(items.peekLast());
            items.removeLast();
        }
        items.addFirst(item);
        map.put(item.name, item);
    }

    public Item access(String str) {
        Item item = map.get(str);
        if (item == null) {
            return null;
        }
        items.remove(item); // this may be O(n) instead of the O(1) that we wanted.
        items.addFirst(item);
        return item;
    }

    public LinkedList<Item> getItems() {
        return items;
    }
}
