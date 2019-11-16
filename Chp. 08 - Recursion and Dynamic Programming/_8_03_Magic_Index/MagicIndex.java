// github.com/RodneyShag

package _8_03_Magic_Index;

public class MagicIndex {
    // Part 1 - Use standard Binary Search: O(log n) time on sorted array. Only works if no duplicate numbers
    public static Integer magicFast(int[] sortedArray) {
        int lo = 0;
        int hi = sortedArray.length - 1;

        while (lo <= hi) {
            int midIndex = (lo + hi) / 2;
            int midValue = sortedArray[midIndex];
            if (midValue == midIndex) {
                return midIndex;
            } else if (midValue > midIndex) {
                hi = midIndex - 1;
            } else {
                lo = midIndex + 1;
            }
        }
        return null;
    }

    // Part 2 - If integers in sorted array are NOT UNIQUE. O(n) runtime, O(n) space complexity.
    public static Integer magicFast2(int[] sortedArray) {
        return magicFast2(sortedArray, 0, sortedArray.length - 1);
    }

    private static Integer magicFast2(int[] sortedArray, int start, int end) {
        if (start > end || start < 0 || end >= sortedArray.length) {
            return null;
        }
        int midIndex = (start + end) / 2;
        int midValue = sortedArray[midIndex];
        if (midValue == midIndex) {
            return midIndex;
        }

		// Search Left. If we find the result, return it.
        int leftIndex = Math.min(midValue, midIndex - 1); // see algorithm in book for explanation if this line is confusing.
        Integer left = magicFast2(sortedArray, start, leftIndex);
        if (left != null) {
            return left;
        }

        // Search Right (Since we couldn't find it in left)
        int rightIndex = Math.max(midValue, midIndex + 1);
        return magicFast2(sortedArray, rightIndex, end);
    }
    
    // For Part 2, an alternate solution is to just loop through the array in search of the value for O(n) time, O(1) space complexity
}
