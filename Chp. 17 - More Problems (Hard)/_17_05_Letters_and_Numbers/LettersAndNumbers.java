// github.com/RodneyShag

package _17_05_Letters_and_Numbers;

import java.util.*;

// Algorithm
//
// 1. Create "deltas" array. Each value in this array will 
//    represent (number of letters) minus (number of numbers) seen so far.
// 2. Create a HashMap<Integer, Integer>, that for each delta, 
//    it saves the first index we saw this delta in our array
//    - "key" is the "delta" calculated earlier
//    - "value" is first index of this delta in original array

// Example
// 
//  index: [ 0  1  2  3  4  5  6  7]
//  input: [ 0  0  a  0  0  0  a  a]
// deltas: [-1 -2 -1 -2 -3 -4 -3 -2]
//
// In our deltas array, if we encounter the same value twice, it means 
// the number of letters and the number of numbers are equal between these indices.
//
// The largest valid subarray corresponds to the largest j-i where deltas[i] equals deltas[j].
// In this case, i=1, j=7, deltas[i] == deltas[j] == -2, and j-i = 7-1 = 6.
// This corresponds to subarray (i, j] which is [a, 0, 0, 0, a, a]

public class LettersAndNumbers {
    public static char[] maxSubarray(char[] array) {
        if (array == null) {
            return new char[0];
        }
        int[] deltas = findDeltas(array);

        int startIndex = -1;
        int endIndex = -1;
        Map<Integer, Integer> map = new HashMap();
        map.put(0, -1); // for testcases such as [a, 0], [a, 0, 0]
        int maxLength = 0;
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(deltas[i])) {
                map.put(deltas[i], i);
            } else {
                if (i - map.get(deltas[i]) > maxLength) {
                    maxLength = Math.max(maxLength, i - map.get(deltas[i]));
                    startIndex = map.get(deltas[i]);
                    endIndex = i;
                }
            }
        }
        return Arrays.copyOfRange(array, startIndex + 1, endIndex + 1);
    }

    private static int[] findDeltas(char[] array) {
        int[] deltas = new int[array.length];
        int delta = 0;
        for (int i = 0; i < array.length; i++) {
            if (Character.isLetter(array[i])) {
                delta++;
            } else if (Character.isDigit(array[i])) {
                delta--;
            }
            deltas[i] = delta;
        }
        return deltas;
    }
}

//  Time Complexity: O(n)
// Space Complexity: O(n)
