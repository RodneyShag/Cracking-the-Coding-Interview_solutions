package _7_12_Hash_Table;

public class Cell<K, V> { // public variables for simplicity.
    K key;
    V value;

    Cell(K k, V v) {
        key = k;
        value = v;
    }

    public boolean equivalent(K k) {
        return key.equals(k);
    }
}
