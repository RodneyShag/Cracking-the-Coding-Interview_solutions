package _8_13_Stack_of_Boxes;

import java.util.ArrayDeque;
import java.util.HashMap;

// Famous box stacking problem 
// 
// (Solution based off book's 2nd solution)
// 
// Tips:
// - Have "Box" class with ".canBeAbove(Box other)" function.
// - Use HashMap<Box, ArrayDeque<Box>> to cache found solutions. (Need to override .equals() and hashCode()).
// - Having "Box bottom" as a parameter is crucial but hard to think of.
// - Deep copy (which is what I did) or cloning (which is what book did) is needed to avoid insidious bugs.

public class StackOfBoxes {
    public static ArrayDeque<Box> buildTallestStack(ArrayDeque<Box> boxes) {
        return buildTallestStack(boxes, null, new HashMap<Box, ArrayDeque<Box>>());
    }

    public static ArrayDeque<Box> buildTallestStack(ArrayDeque<Box> boxes, Box bottom, HashMap<Box, ArrayDeque<Box>> cache) {
        if (cache.containsKey(bottom)) { // checks to see if we already computed the solution
            /* CRUCIAL to do a deep copy. The result we return is going to be altered, and we don't want the key of an entry
               already placed in the HashMap to be altered. Without deep copy, we get incorrect solutions when testing */
            return deepCopy(cache.get(bottom)); 
        }

        int currHeight = 0;
        int bestHeight = 0;
        ArrayDeque<Box> currStack = new ArrayDeque<>();
        ArrayDeque<Box> bestStack = new ArrayDeque<>();

        for (Box box : boxes) {
            if (box.canPlaceAbove(bottom)) {
                currStack = buildTallestStack(boxes, box, cache);
                currHeight = stackHeight(currStack);
                if (currHeight > bestHeight) {
                    bestHeight = currHeight;
                    bestStack = currStack;
                }
            }
        }

        if (bottom != null) {
            bestStack.addFirst(bottom);
            cache.put(bottom, bestStack);
        }

        return bestStack;
    }

    private static int stackHeight(ArrayDeque<Box> boxes) {
        if (boxes == null) {
            return 0;
        }
        int height = 0;
        for (Box box : boxes) {
            height += box.height;
        }
        return height;
    }

    private static ArrayDeque<Box> deepCopy(ArrayDeque<Box> boxes) {
        ArrayDeque<Box> result = new ArrayDeque<>();
        for (Box box : boxes) {
            result.add(new Box(box));
        }
        return result;
    }
}
