package chapter7;
/* Used in 7.6. I did it slightly differently than book */
public class Line {
	public static double epsilon = 0.0001;	//notice slightly more efficient to make this static.

	public double intercept = 0;	//usually y-intercept, but if infiniteSlope==true, it will be x-intercept.
	public double slope = 0;
	public boolean infiniteSlope;	//IMPORTANT
	
	public Line(Point p, Point q){
		/* y = mx + b */
		if (Math.abs(p.x - q.x) < epsilon){
			infiniteSlope = true;
			intercept = floorEpsilon(p.x);	
		}
		else{
			infiniteSlope = false;
			slope = (p.y - q.y) / (p.x - q.x);
			intercept = p.y - slope * p.x;	//from y = mx + b ----> b = y - mx
			slope = floorEpsilon(slope);
			intercept = floorEpsilon(intercept);
		}
	}

	/*** Must override both .equals() and .hashCode() for code to work properly. Surprised I got this to work. ***/
	@Override
	public boolean equals(Object obj){
		if (obj == this)
			return true;
		if (obj == null || obj.getClass() != this.getClass())
			return false;
		Line otherLine = (Line) obj;
		if (infiniteSlope && otherLine.infiniteSlope && areEquivalent(intercept, otherLine.intercept))
			return true;	//same vertical lines
		if (!infiniteSlope && !otherLine.infiniteSlope && areEquivalent(slope, otherLine.slope) && areEquivalent(intercept, otherLine.intercept))
			return true;
		return false;
	}
	
	@Override
	public int hashCode(){
		return (int) (7 * intercept + 31 * slope);
	}
	
	private double floorEpsilon(double num){	//cool trick from book.
		int r = (int) (num / epsilon);	//typecast is necessary
		return (double) (r * epsilon);
	}
	
	private boolean areEquivalent(double a, double b){
		return Math.abs(a - b) < epsilon;		//do I even need this?...since I round everything to nearest epsilon before saving it.
	}
}
