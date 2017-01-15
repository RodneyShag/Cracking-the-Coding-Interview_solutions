package EightPoint10;
import java.util.ArrayList;
import java.util.LinkedList;

/* Tricks:
 * - Create Cell<K,V> class
 * - Represented everything as ArrayList of LinkedLists (not an array of LinkedList like book)
 */
public class Hash<K, V> {
	private int MAX_SIZE = 10;
	ArrayList<LinkedList<Cell<K,V>>> items = new ArrayList<LinkedList<Cell<K,V>>>(MAX_SIZE);
	
	/* Crappy hash */
	public int hashCodeOfKey(K key){
		return key.toString().length() % MAX_SIZE;
	}
	
	public void put(K key, V value){
		/* Find the LinkedList that we should put the Cell in */
		int code = hashCodeOfKey(key);
		LinkedList<Cell<K,V>> list = items.get(code);
		if (list == null)
			list = new LinkedList<Cell<K,V>>();
		
		for (Cell<K,V> c : list){
			if (c.equivalent(key)){
				c.setValue(value);	//just replaces the old value.
				return;
			}
		}
		list.add(new Cell<K,V>(key, value));	//we create a "new" cell!
	}
	
	public V get(K key){
		/* Find the LinkedList that may contain the value */
		int code = hashCodeOfKey(key);
		LinkedList<Cell<K,V>> list = items.get(code);
		if (list == null)
			return null;
		
		for (Cell<K,V> c : list){
			if (c.equivalent(key))
				return c.getValue();
		}

		return null; //failure.
	}
}
