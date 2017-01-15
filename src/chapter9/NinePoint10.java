package chapter9;
import java.util.ArrayList;
import java.util.HashMap;

/* Ignore Solution #1 in book (inefficient and stupid). Here is solution #2 (using dynamic programming) which is based off solution #1 */
/* Tips:
 * - Have "Box" class with ".canBeAbove(Box other)" function
 * - Dynamic Programming is simple: Just us a HashMap to save results, and pass it as a parameter. Only 3 additional lines of code in main algo.
 * - Having "Box bottom" as a parameter is crucial but hard to think of.
 * - Don't forget, the "height" is not the number of boxes, it is the sum of the box heights.
 * - Don't forget ".clone()"
 */
public class NinePoint10 {
	public static ArrayList<Box> buildTallestStack(ArrayList<Box> boxes) {
		if (boxes == null) 
			return null;
		HashMap<Box, ArrayList<Box>> cache = new HashMap<Box, ArrayList<Box>>();
		return buildTallestStack(boxes, null, cache);
	}
	 
	/* Seeing the base case is weird. I think it's when the main loop doesn't make any recursive calls */
	public static ArrayList<Box> buildTallestStack(ArrayList<Box> boxes, Box bottom, HashMap<Box, ArrayList<Box>> cache){
		if (cache.containsKey(bottom))
			return cache.get(bottom);		//since no need to recompute the solution. We've already saved it in the HashMap
		
		ArrayList<Box> bestStack = new ArrayList<Box>();
		ArrayList<Box> currentStack = new ArrayList<Box>();
		int bestHeight = 0;
		int currentHeight = 0;
		
		for (Box b : boxes){
			if(b.canPlaceAbove(bottom)){
				currentStack = buildTallestStack(boxes, b, cache);
				currentHeight = stackHeight(currentStack);
				if (currentHeight > bestHeight){
					bestHeight = currentHeight;
					bestStack = currentStack;		// I wasn't aware you could simply assign a Stack to another Stack.
				}	
			}
		}
		
		if (bottom != null)
			bestStack.add(0, bottom);
		cache.put(bottom, bestStack);			//book nor I check for "bottom == null" here
		return bestStack;						//book (but not website) returns a clone here. I don't think it's necessary but unsure.
	}
	
	private static int stackHeight(ArrayList<Box> boxes){
		if (boxes == null)	//Here just in case but this code should never run since we do "if(b.canPlaceAbove(bottom))"...
			return 0;		//...before calling this function
		int height = 0;
		for (Box box : boxes){
			height += box.height;
		}
		return height;
	}
}
