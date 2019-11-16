// github.com/RodneyShag

package __Intro_Binary_Search;

public class BinarySearch {

    /*****************************/
    /* Binary Search - Iterative */
    /*****************************/
    public static Integer Iterative(int[] sortedArray, int value) {
        int start = 0;
        int end = sortedArray.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (sortedArray[mid] > value) {
                end = mid - 1;
            } else if (sortedArray[mid] < value) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return null;
    }

    /*****************************/
    /* Binary Search - Recursive */
    /*****************************/
    public static Integer Recursive(int[] sortedArray, int value) {
        return RecursiveHelper(sortedArray, value, 0, sortedArray.length - 1);
    }

    /* Since this is tail-recursive, the compiler will optimize it to iterative code */
    private static Integer RecursiveHelper(int[] array, int value, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2; // to avoid integer overflow, can say: mid = start + ((end - start) / 2)
        if (array[mid] > value) {
            return RecursiveHelper(array, value, start, mid - 1);
        } else if (array[mid] < value) {
            return RecursiveHelper(array, value, mid + 1, end);
        } else {
            return mid; // Returns index
        }
    }
}

//  Time Complexity: O(log n)
// Space Complexity: O(1) for Iterative solution, O(log n) for Recursive solution