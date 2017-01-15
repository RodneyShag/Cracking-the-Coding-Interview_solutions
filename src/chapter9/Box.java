package chapter9;
/* Used in 9.10 */
public class Box {
	int width;
	int height;
	int depth;
	
	/* Constructor */
	Box(int w, int h, int d){
		width = w;
		height = h;
		depth = d;
	}
	
	public boolean canPlaceAbove(Box other){
		return (other == null) ||(width < other.width && height < other.height && depth < other.depth);
		// the (other == null) is so the bottom-most box can be placed on anything
	}
}
