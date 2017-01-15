package FourteenPoint6;
import java.util.ArrayList;

public class CircularArray<T> {
	int capacity = 100;
	ArrayList<T> items = new ArrayList<T>(capacity); 	//book does this with T[], which makes more sense, instead of having "capacity"
	int head = 0;
	
	private int convert(int index){
		if (index < 0)
			index += items.size();
		return (index + head) % capacity;
	}
	
	public T get(int index){
		return items.get(convert(index));
	}
	
	public void set(int index, T item){
		items.set(convert(index), item);
	}
	
	public void rotate(int shiftRight){
		head = convert(shiftRight);		//kinda tricky to see why this works. Normal code woulda said "head = (head + shiftRight) % items.size()
	}	                                //which is the same as the function "convert" that we called.
	
	
	/* Part 2 of this question asks us to implement "Iterable". I doubt I'll have to do something this specific in an interview. Tricks:
	 * - The constructor gave it access to the array.
	 * - Used a private counter to keep track of where it is in the array.
	 */
}
