package common;

//Useful equations:
//- Line: y = mx + b
//- Slope: (y2 - y1) / (x2 - x1)
//
//Tricks:
//- We represent a Line in 2 different ways
//    1) Vertical Lines: infiniteSlope and x_intercept (We treat vertical lines separately to avoid div-by-0 errors)
//    2) Non-vertical Lines: slope and y_intercept
//- Must use epsilon to see if 2 doubles are equal to each other (within a margin of error)
//- Make Line's variables "final" so they don't change when Lines are hashed, making Line (basically) immutable

public class Line {
	private static final double epsilon = 0.0001;
	public final Double slope;          // I use Double instead of double to be able to set it to null.
	public final Double y_intercept;
	public final boolean infiniteSlope;	// Important
	public final double  x_intercept;   // We want to know x_intercept in case line has infinite slope
	
	/* Constructor */
	public Line(double slope, double y_intercept) {
		this.slope       = slope;
		this.y_intercept = y_intercept;
		infiniteSlope    = false;
		/* Set x_intercept */
		if (y_intercept == 0) {
			x_intercept = 0;
		} else {
			x_intercept = (-1 * slope) / y_intercept; // y = mx + b   -->   0 = mx + b   -->  b = -mx
		}
	}

	/* Constructor */
	public Line(Point p1, Point p2) {
		if (areEquivalent(p1.x, p2.x)) {
			slope         = null;
			y_intercept   = null;
			infiniteSlope = true;
			x_intercept   = p1.x;
		} else {
			infiniteSlope = false;
			slope         = (p1.y - p2.y) / (p1.x - p2.x);
			y_intercept   = p1.y - slope * p1.x; // to find y_intercept, we just plug in 1 of the Points into equation of line
			if (y_intercept == 0) {
				x_intercept = 0;
			} else {
				x_intercept = (-1 * slope) / y_intercept;
			}
		}
	}
	
	/* Can't simply compare doubles using == */
	public static boolean areEquivalent(double a, double b) {
		return Math.abs(a - b) < epsilon;
	}
	
	// Must override both .equals() and .hashCode() for Lines to be hashed properly:
	// http://stackoverflow.com/questions/27581/what-issues-should-be-considered-when-overriding-equals-and-hashcode-in-java
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		} else if (obj == null || !(obj instanceof Line)) {
			return false;
		} 
		Line otherLine = (Line) obj;
		return LineFunctions.sameLine(this, otherLine);
	}
	
	@Override
	public int hashCode() {
		return (int) (2 * x_intercept
				    + 3 * (y_intercept == null ? 0 : y_intercept)
				    + 5 * (slope == null ? 0 : slope));
	}
	
	@Override
	public String toString() {
		if (infiniteSlope) {
			return "Line: Vertical line at x = " + x_intercept;
		} else {
			return "Line: slope = " + slope + "   y-intercept = " + y_intercept;
		}
	}
}
