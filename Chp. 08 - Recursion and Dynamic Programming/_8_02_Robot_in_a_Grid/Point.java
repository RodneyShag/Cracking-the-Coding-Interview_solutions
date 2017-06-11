package _8_02_Robot_in_a_Grid;

/* Used in 9.2 */
public class Point {
	public int x;
	public int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// Good reads:
	// http://javarevisited.blogspot.com/2011/02/how-to-write-equals-method-in-java.html
	// http://javarevisited.blogspot.com/2011/10/override-hashcode-in-java-example.html

	/* Here for 9.2 to work with hashing Points */
	@Override
	public boolean equals(Object other) { // must take an "Object" as a
											// parameter, not a "Point", so that
											// it overrides the .equals method
		if (other == this) {
			return true;
		} else if (other == null || !(other instanceof Point)) {
			return false;
		}
		Point otherPoint = (Point) other;
		return this.x == otherPoint.x && this.y == otherPoint.y;
	}

	@Override
	public int hashCode() {
		return 13 * x + 7 * y;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
