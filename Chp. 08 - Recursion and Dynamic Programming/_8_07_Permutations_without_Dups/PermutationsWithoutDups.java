// github.com/RodneyShag

package _8_07_Permutations_without_Dups;

import java.util.*;

public class PermutationsWithoutDups {
    public static List<List<Integer>> permute(int[] array) {
        if (array == null || array.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> solutions = new ArrayList<>();
        permute(array, 0, new boolean[array.length], solutions, new ArrayList<>());
        return solutions;
    }

    private static void permute(int[] array, int index, boolean[] used, List<List<Integer>> solutions, List<Integer> list) {
        if (index == array.length) {
            solutions.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (used[i] == false) {
                list.add(array[i]);
                used[i] = true;
                permute(array, index + 1, used, solutions, list);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
