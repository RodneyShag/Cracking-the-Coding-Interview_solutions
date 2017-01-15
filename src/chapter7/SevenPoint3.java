package chapter7;
/* Tricks:
 * A line is represented as a "slope" and "y-intercept"
 * Must use "epsilon/precision" since this are doubles. Use:  Math.abs(yintercept - line.yintercept) < precision;
 */
/* Code copied from website */
public class SevenPoint3 { /*class Line*/
	//  Two same lines are considered to be intersected.
	  
	  static double precision = 0.0000001;
	  double slope;			//Rodney: this implementation doesn't account for infinite slopes!
	  double yintercept;
	  
	  public SevenPoint3 /*class Line*/ (double slope, double yintercept) {
	      this.slope = slope;
	      this.yintercept = yintercept;
	  }
	  
	  boolean intersect(SevenPoint3 line) {
	      //XXX: Don't assume that the slope and y-intercept are integers.
	      //Understand limitations of floating point representations. Never check for equality
	      //with ==. Instead, check if the difference is less than an epsilon value.
	      return Math.abs(slope - line.slope) > precision ||                //lines with different slopes
	             (Math.abs(slope - line.slope) < precision && Math.abs(yintercept - line.yintercept) < precision);	//same line
	  }
}
