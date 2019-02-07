package _7_12_Hash_Table;

import java.util.ArrayList;
import java.util.LinkedList;

import __Intro_Prime.Prime;

// Hints:
// - Create Cell<K,V> generic class
// - Represent everything as ArrayList of LinkedLists of Cells

public class Hash<K, V> {
    private int MAX_SIZE;                            // Initial MAX_SIZE of our ArrayList
    private ArrayList<LinkedList<Cell<K,V>>> items;  // Our main data structure to hold Cells
    private int numItems;                            // number of items saved in our data structure
    private boolean [] primes;                       // will hold prime numbers as "true"
    private int primeArraySize;                      // size of our "boolean[] prime" array

    /* Constructor */
    public Hash() {
        MAX_SIZE = 3; // small to test resizing
        items = new ArrayList<>(MAX_SIZE);
        for (int i = 0; i < MAX_SIZE; i++) {
            items.add(new LinkedList<>()); // Crucial. We don't magically get LinkedLists even though we created an ArrayList of a certain size
        }
        numItems = 0;
        primeArraySize = 100;
        primes = Prime.generatePrimes(primeArraySize);
    }

    public Hash(int size) {
        this();
        MAX_SIZE = size;
    }

    /* Bad hash function: may not distribute keys uniformly */
    public int hashCodeOfKey(K key) {
        return key.toString().length() % MAX_SIZE; // should the % be done here or elsewhere?
    }

    public void put(K key, V value) {
        /* Find the LinkedList that we should put the Cell into */
        int hashKey = hashCodeOfKey(key);
        LinkedList<Cell<K, V>> list = items.get(hashKey);

        for (Cell<K, V> cell : list) {
            if (cell.equivalent(key)) {
                cell.setValue(value); // overwrites the old value.
                return;
            }
        }
        numItems++;
        if (calculateLoadFactor() > 0.7) {
            increaseSize();
        }
        list.add(new Cell<K, V>(key, value)); // create a new Cell and add it to our LinkedList
    }

    public V get(K key) {
        /* Find the LinkedList that may contain the value */
        int code = hashCodeOfKey(key);
        LinkedList<Cell<K, V>> list = items.get(code);

        if (list == null) {
            return null;
        }
        for (Cell<K, V> cell : list) {
            if (cell.equivalent(key)) {
                return cell.getValue();
            }
        }

        return null; // failure
    }

    /* Used to resize array when it gets too full */
    public double calculateLoadFactor() {
        return (double) numItems / MAX_SIZE;
    }

    public void increaseSize() {
        int nextPrime = getNextPrime();
        if (nextPrime == -1) { // error
            return;
        }
        Hash<K, V> hashNew = new Hash<K, V>(nextPrime);
        for (LinkedList<Cell<K, V>> list : items) {
            for (Cell<K, V> cell : list) {
                hashNew.put(cell.getKey(), cell.getValue());
            }
        }
        MAX_SIZE = nextPrime;
        items = hashNew.items;
    }

    public int getNextPrime() {
        return Prime.getNextPrime(primes, 2 * MAX_SIZE);
    }

    public int getMaxSize() {
        return MAX_SIZE;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        for (LinkedList<Cell<K, V>> list : items) {
            for (Cell<K, V> cell : list) {
                result.append("key = " + cell.getKey() + "   value = " + cell.getValue() + "\n");
            }
        }
        return result.toString();
    }
}
