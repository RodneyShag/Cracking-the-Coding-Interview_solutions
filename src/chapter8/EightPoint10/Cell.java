package chapter8.EightPoint10;

public class Cell<K,V> {
	private K key;
	private V value;
	
	/* Constructor */
	Cell(K k, V v){
		key = k;
		value = v;
	}
	
	/* Setters */
	public void setKey(K k){
		key = k;
	}
	public void setValue(V v){
		value = v;
	}
	
	/* Getters */
	public K getKey(){ 
		return key; 
	}
	public V getValue(){ 
		return value;
	}
	
	/* Functions to test equivalence */
	public boolean equivalent(Cell<K,V> cell){
		return equivalent(cell.getKey());
	}
	
	public boolean equivalent(K k){
		return key.equals(k);	//can't do == for Objects because that won't just check if they REFER to the same object.
	}
}
