package chapter3;
import java.util.Stack;

/* Used in 3.4 */
/* It is just a stack, including 1) Error Checking 2) Index to say which tower it is */
public class Tower {
	Stack<Integer> disks;
	int index;
	
	public Tower(int i){
		disks = new Stack<Integer>();
		index = i;
	}
	
	public void add(int d){
		if (!disks.isEmpty() && disks.peek() <= d)
			System.out.println("Error Placing Disk " + d);
		else
			disks.push(d);
	}
	
	public Integer remove(){
		if (disks.isEmpty())
			return null;
		else
			return disks.pop();
	}
}
