package _10_05_Sparse_Search;

// Algorithm: 
// - Binary Search
// - If middle value is "", search linearly left, then right, to find non-empty String
// - Use Math.min/Math.max trick below for faster runtime

public class SparseSearch {
	public static Integer find(String[] sortedArray, String str) {
		return find(sortedArray, str, 0, sortedArray.length - 1);
	}
	
	private static Integer find(String[] sortedArray, String str, int start, int end) {
		if (start > end) {
			return null;
		}
		int originalMidIndex = (start + end) / 2;
		int midIndex         = originalMidIndex;
		String midValue = sortedArray[midIndex];
		
		/* Find nonempty String */
		while (midIndex > start && midValue.isEmpty()) { // linear search left for any non-empty String
			midIndex--;
			midValue = sortedArray[midIndex];
		}
		while (midIndex < end && midValue.isEmpty()) { // linear search right for any non-empty String
			midIndex++;
			midValue = sortedArray[midIndex];
		}
		if (midValue == "") {
			return null;
		}
		
		/* Now can apply standard binary search 
		 * - For faster runtime, do the Math.max/Math.min trick I do below (which book forgot to do) */
		if (midValue.equals(str)) { // make sure not to use " == " here
			return midIndex;
		} else if (midValue.compareTo(str) < 0) {
			return find(sortedArray, str, Math.max(midIndex, originalMidIndex) + 1, end);
		} else {
			return find(sortedArray, str, start, Math.min(midIndex, originalMidIndex) - 1);
		}
	}
}
