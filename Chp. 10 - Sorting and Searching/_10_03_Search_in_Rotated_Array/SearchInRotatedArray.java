package _10_03_Search_in_Rotated_Array;

// - Trick: Endpoints of array give us valuable information. We apply a modified binary search to this problem.
// - Although binary search compares the "middle value" to the "target value", we will break up
//   the cases differently. We will compare middle value `A[mid]` to the start value `A[lo]`
// - Array can only have 1 inflection point, therefore it is either to the left or right of `mid`. 
//   That means 1/2 of the array is ordered normally (in increasing order) and the other half has the inflection point.

public class SearchInRotatedArray {
    public static Integer search(int[] A, int target) {
        int lo = 0;
        int hi = A.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (A[mid] == target) {
               return mid;
            }
            if (A[lo] < A[mid]) { // in this case, left side CANNOT have inflection point, and is increasing.
                if (A[lo] <= target && target < A[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else if (A[lo] > A[mid]) {
                if (A[mid] < target && target <= A[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else { // This iteration of while loop did not divide problem in half.
                lo++; // Removes just 1 invalid match.
            }
        }
        return null;
    }
}

//  Time Complexity: O(n) due to possible duplicates in array
// Space Complexity: O(1)
