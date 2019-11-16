// github.com/RodneyShag

package _8_13_Stack_of_Boxes;

import java.util.*;

// Based off Cracking the Coding Interview 6th Edition's Solution 1

// Algorithm
//
// 1. Create Box class with `.canBeAbove(Box other)` function.
// 2. Sort Boxes in descending height order. This ensures we don't have to look backwards in the list 
//     - This problem uses `<` instead of `<=` for Box heights. If we have 2 Boxes of equal height,
//       such as [width, height, depth] of [4,4,4] and [7,4,7], it doesn't matter which Box comes first
//       after sorting, since both Boxes can't be in the final solution. Box 1 cannot be on top of Box 2,
//       and Box 2 cannot be on top of Box 1.
// 3. Experiment with each Box as a bottom and build the biggest stack possible.
// 4. Use a "Map<Integer, Integer>" cache to save solutions to sub-problems
//     1. "key" is the index `i` in the List of boxes
//     2. "value" is the max height possible with "Box i" at the bottom

public class StackOfBoxes {
    public static int findMaxHeight(List<Box> boxes) {
        if (boxes == null || boxes.size() == 0) {
            return 0;
        }
        Collections.sort(boxes, (box1, box2) -> box2.height - box1.height); // sort in descending height order
        return findMaxHeight(boxes, -1, new HashMap<Integer, Integer>());
    }

    private static int findMaxHeight(List<Box> boxes, int bottomIndex, Map<Integer, Integer> cache) {
        if (cache.containsKey(bottomIndex)) {
            return cache.get(bottomIndex);
        }

        int maxHeight = 0;
        Box bottom = bottomIndex == -1 ? null : boxes.get(bottomIndex);

        for (int i = bottomIndex + 1; i < boxes.size(); i++) {
            if (boxes.get(i).canBeAbove(bottom)) {
                int height = findMaxHeight(boxes, i, cache);
                maxHeight = Math.max(maxHeight, height);
            }
        }

        maxHeight += bottomIndex == -1 ? 0 : bottom.height; 
        cache.put(bottomIndex, maxHeight);
        return maxHeight;
    }
}

//  Time Complexity: O(n^2)
// Space Complexity: O(n) due to recursion.


// Alternate Solution: Cracking the Coding Interview 6th Edition Solution 2
//
// I didn't like this alternate solution since caching was done weirdly: Function had 2 changing
// parameters (Box bottom, int offset) but cache only used 1 parameter.


// Follow-up Question - What if rotation of boxes is allowed?
//
// 1. For each box, rotate it to all 6 possibilities: [w h d], [w d h], [h w d] [h d w], [d w h], [d h w].
// 2. Notice it's impossible to stack 2 of these 6 boxes on top of each other, so if we insert all 6 boxes
//    into our list, we're still ensured only 1 of them can be selected for our solution.
// 3. Create `List<Box> boxes` that is 6 times as large as the original list of boxes. Solve the problem for this list.
