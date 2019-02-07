package _10_03_Search_in_Rotated_Array;

// - Trick: Endpoints of array give us valuable information. We apply a modified binary search to this problem.
//
// - Pitfall: We want to break up the cases by comparing midValue to leftValue. DO NOT break it up by comparing midValue to the
//            value we are searching for like in binary search
//         
// - Array can only have 1 inflection point, therefore it is either to the left or right of midIndex. That means 1/2 of the array
//   is ordered normally (in increasing order) and the other half has the inflection point.

public class SearchInRotatedArray {
    public static Integer search(int[] rotatedArray, int x) {
        return search(rotatedArray, x, 0, rotatedArray.length - 1);
    }

    private static Integer search(int[] rotatedArray, int x, int start, int end) {
        if (start > end) {
            return null;
        }
        int midIndex = (start + end) / 2;
        int midValue = rotatedArray[midIndex];

        int leftValue  = rotatedArray[start];
        int rightValue = rotatedArray[end];

        if (midValue == x) {
            return midIndex;
        } else if (leftValue < midValue) { // in this case, left CANNOT have inflection point, thus is ordered correctly
            if (leftValue <= x && x < midValue) {
                return search(rotatedArray, x, start, midIndex - 1);
            } else {
                return search(rotatedArray, x, midIndex + 1, end);
            }
        } else if (leftValue > midValue) { // in this case, left MUST have inflection point, and thus is not ordered correctly
            if (midValue < x && x <= rightValue) {
                return search(rotatedArray, x, midIndex + 1, end);
            } else {
                return search(rotatedArray, x, start, midIndex - 1);
            }
        } else { // leftValue == midValue
            if (midValue == rightValue) { // leftValue == midValue == rightValue, so we must search both halves of array since either half could have inflection point
                Integer result = search(rotatedArray, x, start, midIndex - 1);
                if (result == null) {
                    result = search(rotatedArray, x, midIndex + 1, end);
                }
                return result;
            } else { // in this case, inflection point is on right side of array
                return search(rotatedArray, x, midIndex + 1, end);
            }
        }
    }
}

// Time Complexity: O(log n) average case, but O(n) worst case if there are many duplicates.
