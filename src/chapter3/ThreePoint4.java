package chapter3;

/* Also uses Tower class */
public class ThreePoint4 {
	public static void moveDisks(int n, Tower origin, Tower destination, Tower buffer){
		if (n > 0){ // base case
			/* Recursive case */
			moveDisks(n-1, origin, buffer, destination);
			moveTop(origin, destination);
			moveDisks(n-1, buffer, destination, origin);
		}
	}
	
	/* We teach it how to move 1 disk. Therefore it can recursively move n disks */
	public static void moveTop(Tower start, Tower end){
		Integer disk = start.pop();
		end.push(disk);
		System.out.println("Move disk " + disk + " from Tower " + start.towerNum + " to Tower " + end.towerNum);
	}
}
