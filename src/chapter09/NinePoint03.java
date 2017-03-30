package chapter09;

public class NinePoint03 {
	/* Part 1 - Use standard Binary Search: O(log n) time on sorted array. Only works if no duplicate numbers */
	public static Integer magicFast(int [] sortedArray) {
		if (sortedArray == null) {
			return null;
		}
		return magicFast(sortedArray, 0, sortedArray.length - 1);
	}
	
	public static Integer magicFast(int [] sortedArray, int start, int end) {
		if (start > end) {
			return null;
		}
		int midIndex = (start + end) / 2;
		int value = sortedArray[midIndex];
		if (value == midIndex) {
			return midIndex;
		} else if (value > midIndex) {
			return magicFast(sortedArray, start, midIndex - 1);
		} else {
			return magicFast(sortedArray, midIndex + 1, end);
		}
	}
	
	/* Part 2 - If integers in sorted array are NOT UNIQUE. Algorithm from book */
	public static Integer magicFast2(int [] sortedArray) {
		if (sortedArray == null) {
			return null;
		}
		return magicFast2(sortedArray, 0, sortedArray.length - 1);
	}
	
	public static Integer magicFast2(int [] sortedArray, int start, int end) {
		if (start > end || start < 0 || end >= sortedArray.length) {
			return null;
		}
		int midIndex = (start + end) / 2;
		int midValue = sortedArray[midIndex];
		if (midValue == midIndex) {
			return midIndex;
		}
		
		/* Search Left. If we find the result, return it. */
		int leftIndex = Math.min(midValue, midIndex - 1); // see algorithm in book for explanation if this line is confusing.
		Integer left = magicFast2(sortedArray, start, leftIndex);
		if (left != null) {
			return left;
		}
		
		/* Search Right (Since we couldn't find it in left) */
		int rightIndex = Math.max(midValue, midIndex + 1);
		return magicFast2(sortedArray, rightIndex, end);
	}
}
