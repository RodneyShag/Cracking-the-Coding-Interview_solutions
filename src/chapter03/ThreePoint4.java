package chapter03;

import java.util.ArrayDeque;

public class ThreePoint4 {
	public static void moveDisks(int n, Tower origin, Tower destination, Tower buffer) {
		if (n > 0) {
			moveDisks(n-1, origin, buffer, destination);
			moveTop(origin, destination);
			moveDisks(n-1, buffer, destination, origin);
		}
	}
	
	/* We teach it how to move 1 disk. Therefore it can recursively move n disks */
	public static void moveTop(Tower origin, Tower destination) {
		Integer disk = origin.pop();
		destination.push(disk);
		System.out.println("Move disk " + disk + " from Tower " + origin.towerNum + " to Tower " + destination.towerNum);
	}
}

/* It's just a stack, including 1) Error Checking 2) tower number */
class Tower {
	private ArrayDeque<Integer> disks; // use deque as a stack
	public int towerNum;
	
	/* Constructor */
	public Tower(int towerNum) {
		disks = new ArrayDeque<>();
		this.towerNum = towerNum;
	}
	
	/* Can only push a disk onto a stack if there isn't already a smaller disk on it */
	public void push(int d) {
		if (!disks.isEmpty() && disks.peek() <= d) {
			System.out.println("Error Placing Disk " + d);
		} else {
			disks.push(d);
		}
	}
	
	/* Can only pop from a non-empty stack */
	public Integer pop() {
		if (disks.isEmpty()) {
			return null;
		} else {
			return disks.pop();
		}
	}
}
