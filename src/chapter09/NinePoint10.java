package chapter09;

import java.util.ArrayList;
import java.util.HashMap;

/* Famous box stacking problem 
 * 
 * (Solution based off book's 2nd solution)
 * 
 * Tips:
 * - Have "Box" class with ".canBeAbove(Box other)" function.
 * - Use HashMap<Box, ArrayList<Box>> to cache found solutions. (Need to override .equals() and hashCode()).
 * - Having "Box bottom" as a parameter is crucial but hard to think of.
 * - Deep copy (which is what I did) or cloning (which is what book did) is needed to avoid insidious bugs.
 */
public class NinePoint10 {
	
	public static ArrayList<Box> buildTallestStack(ArrayList<Box> boxes) {
		if (boxes == null) {
			return null;
		}
		HashMap<Box, ArrayList<Box>> cache = new HashMap<>();
		return buildTallestStack(boxes, null, cache);
	}

	public static ArrayList<Box> buildTallestStack(ArrayList<Box> boxes, Box bottom, HashMap<Box, ArrayList<Box>> cache) {
		if (cache.containsKey(bottom)) { // checks to see if we already computed the solution
			/* CRUCIAL to do a deep copy. The result we return is going to be altered, and we don't want the key of an entry
			   already placed in the HashMap to be altered. Without deep copy, we get incorrect solutions when testing */
			return deepCopy(cache.get(bottom)); 
		}

		ArrayList<Box> currentStack = new ArrayList<>();
		ArrayList<Box> bestStack    = new ArrayList<>();
		int currentHeight = 0;
		int bestHeight    = 0;
		
		for (Box box : boxes) {
			if (box.canPlaceAbove(bottom)) {
				currentStack  = buildTallestStack(boxes, box, cache);
				currentHeight = stackHeight(currentStack);
				if (currentHeight > bestHeight) {
					bestHeight = currentHeight;
					bestStack  = currentStack;
				}
			}
		}
		
		/* Our bottom box is part of solution */
		if (bottom != null) {
			bestStack.add(0, bottom); // inserts in front of list (that is, bottom of physical box stack)
		}
		cache.put(bottom, bestStack); // caches our computed solution
		return bestStack;
	}
	
	private static int stackHeight(ArrayList<Box> boxes) {
		if (boxes == null) {
			return 0;
		}
		int height = 0;
		for (Box box : boxes) {
			height += box.height;
		}
		return height;
	}
	
	private static ArrayList<Box> deepCopy(ArrayList<Box> boxes) {
		ArrayList<Box> result = new ArrayList<>();;
		for (Box box : boxes) {
			result.add(new Box(box));
		}
		return result;
	}
}
