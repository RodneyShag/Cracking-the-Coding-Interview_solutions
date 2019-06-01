package _17_10_Majority_Element;

import java.util.Arrays;

// Let's assume (for now), that the array has a valid majority element
//
// Loop through the array. At each index `i`, we treat the array as 2 pieces:
//   - prefix as `[0, i)`
//   - suffix as `[i, end]`
// Main idea: If we don't have a majority element in the prefix, then the suffix must have a majority element,
//            and this majority element will also be the majority element for the entire array.

public class MajorityElement {
    public static Integer majorityElement(int[] array) {
    	if (array == null) {
    		return null;
    	}
        Integer majority = getCandidate(array);
        return isMajorityValid(array, majority) ? majority : null;
    }

    private static Integer getCandidate(int[] array) {
        int count = 0;
        Integer candidate = null;

        for (int num : array) {
            if (count == 0) { // no majority element in prefix
                candidate = num; // selects new candidate majority element
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    private static boolean isMajorityValid(int[] array, int majority) {
        long count = Arrays.stream(array).filter(a -> (a == majority)).count();
        return count * 2 > array.length;
    }
}
