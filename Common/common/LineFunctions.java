package common;

public class LineFunctions {
	public static boolean intersect(Line line1, Line line2) { // Fact: 2 non-parallel lines intersect
		/* Handles vertical lines */
		if (line1.infiniteSlope && line2.infiniteSlope && !Line.areEquivalent(line1.x_intercept, line2.x_intercept)) {
			return false; // parallel vertical lines
		} else if (line1.infiniteSlope || line2.infiniteSlope) {
			return true;
		}
		/* Handles non-vertical lines */
		if (Line.areEquivalent(line1.slope, line2.slope) && !Line.areEquivalent(line1.y_intercept, line2.y_intercept)) {
			return false; // parallel non-vertical lines
		}
		return true;
	}
	
	public static boolean sameLine(Line line1, Line line2) {
		/* Handles vertical lines */
		if (line1.infiniteSlope && line2.infiniteSlope) {
			return Line.areEquivalent(line1.x_intercept, line2.x_intercept); // Vertical lines with same x-intercepts are equal
		} else if (line1.infiniteSlope || line2.infiniteSlope) {
			return false; // If only 1 line is vertical, it cannot be equal to the other line
		}
		/* Handles non-vertical lines: Non-vertical lines with equivalent slopes and y_intercepts are equal */
		return Line.areEquivalent(line1.slope, line2.slope) && Line.areEquivalent(line1.y_intercept, line2.y_intercept);
	}
}
