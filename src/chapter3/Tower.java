package chapter3;

import java.util.Stack;

/* Used in 3.4 */
/* It's just a stack, including 1) Error Checking 2) tower number */
public class Tower {
	private Stack<Integer> disks;
	public int towerNum;
	
	/* Constructor */
	public Tower(int towerNum){
		disks = new Stack<Integer>();
		this.towerNum = towerNum;
	}
	
	/* Can only push a disk onto a stack if there isn't already a smaller disk on it */
	public void push(int d){
		if (!disks.isEmpty() && disks.peek() <= d)
			System.out.println("Error Placing Disk " + d);
		else
			disks.push(d);
	}
	
	/* Can only pop from a non-empty stack */
	public Integer pop(){
		if (disks.isEmpty())
			return null;
		else
			return disks.pop();
	}
}
