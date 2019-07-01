package _16_16_Sub_Sort;

// - Find these 2 indices
//   - startIndex: index that, if we sort from startIndex to end, entire array is sorted
//   - endIndex: index that, if we sort from 0 to endIndex, entire array is sorted
// - Sorting from `startIndex` to `endIndex` will make the entire array sorted

public class SubSort {
    public static void minMax(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int startIndex = -1; 
        int endIndex   = -1; 

        // our final answer will be to sort from startIndex to endIndex

        // find endIndex
        int maxSoFar = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < maxSoFar) {
                endIndex = i;
            }
            maxSoFar = Math.max(maxSoFar, array[i]);
        }

        // find startIndex
        int minSoFar = array[array.length - 1];
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] > minSoFar) {
                startIndex = i;
            }
            minSoFar = Math.min(minSoFar, array[i]);
        }

        if (startIndex == -1 || endIndex == -1) {
            System.out.println("Already Sorted");
        } else {
            System.out.println("(" + startIndex + "," + endIndex + ")");
        }
    }
}
