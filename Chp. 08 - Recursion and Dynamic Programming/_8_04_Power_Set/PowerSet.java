// github.com/RodneyShag

package _8_04_Power_Set;

import java.util.*;

public class PowerSet {
    public static List<List<Integer>> getSubsets(int[] array) {
        if (array == null || array.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> solutions = new ArrayList<>();
        makeSubsets(array, 0, solutions, new ArrayList<>());
        return solutions;
    }

    private static void makeSubsets(int[] array, int i, List<List<Integer>> solutions, List<Integer> list) {
        if (i == array.length) {
            solutions.add(new ArrayList<>(list));
            return;
        }

        // don't use array[i]
        makeSubsets(array, i + 1, solutions, list);

        // use array[i]
        list.add(array[i]);
        makeSubsets(array, i + 1, solutions, list);
        list.remove(list.size() - 1);
    }
}

// Time Complexity: O(2^n). Impossible to do better
