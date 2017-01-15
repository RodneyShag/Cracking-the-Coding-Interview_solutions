package chapter3;
/* Memorize this (and Tower class). Don't forget base case! */
public class ThreePoint4 {
	public static void moveDisks(int n, Tower origin, Tower destination, Tower buffer){		//see Tower class.
		if (n > 0){
			moveDisks(n-1, origin, buffer, destination);
			moveTop(origin, destination);
			moveDisks(n-1, buffer, destination, origin);
		}
	}
	
	public static void moveTop(Tower start, Tower end){
		Integer disk = start.remove();
		end.add(disk);
		System.out.println("Move disk " + disk + " from Tower " + start.index + " to Tower " + end.index);
	}
}