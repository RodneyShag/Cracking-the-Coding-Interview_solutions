package _17_05_Letters_and_Numbers;

import java.util.Arrays;
import java.util.HashMap;

// Algorithm:
//  1. Count the "running" differences (between letters and numbers) at each spot in array. Save in int[]
//  2. If 2 indices in our int[] have the same difference, that means there's an equal subarray between them
//  3. To find the max subarray, we find the largest distance between 2 indices with equal differences

public class LettersAndNumbers {
    public static char[] maxSubarray(char[] array) {
        int[] deltas = findDeltas(array);
        Pair pair = findLongestMatch(deltas);
        char[] result = Arrays.copyOfRange(array, pair.left + 1, pair.right + 1);
        return result;
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

    private static Pair findLongestMatch(int[] deltas) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // crucial
        Pair maxPair = new Pair(-1, -1);
        for (int i = 0; i < deltas.length; i++) {
            if (!map.containsKey(deltas[i])) { // we only save the first occurrence of each number we see
                map.put(deltas[i], i);
            } else {
                int leftIndex = map.get(deltas[i]);
                int rightIndex = i;
                Pair pair = new Pair(leftIndex, rightIndex);
                if (pair.getSize() > maxPair.getSize()) {
                    maxPair = new Pair(pair);
                }
            }
        }
        return maxPair;
    }
}

// Time Complexity: O(n)
