// github.com/RodneyShag

package _7_12_Hash_Table;

import java.util.*;

// Hints:
// - Create Cell<K,V> generic class
// - Represent everything as ArrayList of LinkedLists of Cells

public class Hash<K, V> {
    int numBuckets = 3; // small to test resizing. public for testing.
    private ArrayList<LinkedList<Cell<K, V>>> lists = new ArrayList<>(numBuckets);
    private final double LOAD_FACTOR = 0.7;
    private int numItems = 0;

    public Hash() {
        initializeLists(lists);
    }

    private void initializeLists(ArrayList<LinkedList<Cell<K, V>>> lists) {
        for (int i = 0; i < numBuckets; i++) {
            lists.add(new LinkedList<>());
        }
    }

    public int hashCodeOfKey(K key) {
        return key.hashCode() % numBuckets;
    }

    public void put(K key, V value) {
        // Find the LinkedList that we should put the Cell into.
        int hashCode = hashCodeOfKey(key);
        LinkedList<Cell<K, V>> list = lists.get(hashCode);

        // See if we should overwrite an old Cell.
        for (Cell<K, V> cell : list) {
            if (cell.key == key) {
                cell.value = value; // overwrites the old value.
                return;
            }
        }
        
        // Create new Cell and add it to our LinkedList.
        list.add(new Cell<K, V>(key, value));
        numItems++;

        // Rehash if our load factor is too high.
        double loadFactor = (double) numItems / numBuckets;
        if (loadFactor > LOAD_FACTOR) {
            rehash();
        }
    }

    public V get(K key) {
        // Find the LinkedList that may contain the value.
        int hashCode = hashCodeOfKey(key);
        LinkedList<Cell<K, V>> list = lists.get(hashCode);

        for (Cell<K, V> cell : list) {
            if (cell.key == key) {
                return cell.value;
            }
        }
        return null; // key doesn't exist.
    }

    private void rehash() {
        ArrayList<LinkedList<Cell<K, V>>> temp = lists;
        numBuckets *= 2;
        lists = new ArrayList<>(numBuckets);
        initializeLists(lists);
        numItems = 0;
        for (LinkedList<Cell<K, V>> list : temp) {
            for (Cell<K, V> cell : list) {
                put(cell.key, cell.value);
            }
        }
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        for (LinkedList<Cell<K, V>> list : lists) {
            for (Cell<K, V> cell : list) {
                result.append("key = " + cell.key + "   value = " + cell.value + "\n");
            }
        }
        return result.toString();
    }
}
