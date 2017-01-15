package chapter9;

public class NinePoint3 {
	/* Solution 0: Linear search. (Doesn't use fact that array is sorted) */
	public static int magicIndexSlow(int [] sortedArray){
		for (int i = 0; i < sortedArray.length; i++){
			if (sortedArray[i] == i)
				return i;
		}
		return -1;
	}
	
	/* Solution 1 - Use standard Binary Search: O(log n) time on sorted array. Only works if no duplicate numbers */
	public static int magicFast(int [] sortedArray){
		return magicFast(sortedArray, 0, sortedArray.length - 1);
	}
	
	public static int magicFast(int [] sortedArray, int start, int end){
		if (start > end)
			return -1;	//ideally throw an exception so algo can work with negative numbers.
		int midIndex = (start + end) / 2;
		int value = sortedArray[midIndex];
		if (value == midIndex)
			return midIndex;
		else if (value > midIndex)
			return magicFast(sortedArray, start, midIndex - 1);
		else
			return magicFast(sortedArray, midIndex + 1, end);
		//Note: Does not use the "Math.max(value, midIndex + 1)" optimization from solution 2
	}
	
	/* Part 2 - If integers in sorted array are **not unique**. Algorithm from book */
	public static int magicFast2(int [] sortedArray){
		return magicFast2(sortedArray, 0, sortedArray.length - 1);
	}
	
	public static int magicFast2(int [] sortedArray, int start, int end){
		if (start > end)
			return -1;	//ideally throw an exception so algorithm can work with negative numbers.
		int midIndex = (start + end) / 2;
		int value = sortedArray[midIndex];
		if (value == midIndex)
			return midIndex;
		
		/* Search Left. If we find the result, return it. */
		int leftIndex = Math.min(value, midIndex - 1);				//see algorithm in book for explanation if this line is confusing.
		int left = magicFast2(sortedArray, start, leftIndex);
		if (left >= 0)
			return left;
		
		/* Search Right (Since we couldn't find it in left */
		int rightIndex = Math.max(value, midIndex + 1);
		return magicFast2(sortedArray, rightIndex, end);
	}
}
