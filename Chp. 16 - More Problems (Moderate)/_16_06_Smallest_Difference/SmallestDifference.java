package _16_06_Smallest_Difference;

import java.util.Arrays;

// Time Complexity: O(a log a + b log b) where a, b are lengths of the 2 arrays

// Kind of like a "closest 2 sum" problem.

public class SmallestDifference {
    public static int smallestDifference(int[] array1, int[] array2) {
        Arrays.sort(array1);
        Arrays.sort(array2);
        int minDifference = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while (i < array1.length && j < array2.length) {
            int difference = Math.abs(array1[i] - array2[j]);
            minDifference = Math.min(minDifference, difference);
            if (array1[i] == array2[j]) {
                return 0;
            }
            if (array1[i] < array2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return minDifference;
    }
}
