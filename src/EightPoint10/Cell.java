package EightPoint10;
/* Creating this using Generics, with correct syntax, might be tricky to memorize */

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
	
	/* Book had this function */
	public boolean equivalent(K k){
		return key.equals(k);	//can't do == because (I think) it won't work properly for Objects
	}
}
