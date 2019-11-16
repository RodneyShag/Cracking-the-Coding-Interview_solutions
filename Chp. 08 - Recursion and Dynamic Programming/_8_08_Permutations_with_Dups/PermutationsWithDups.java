// github.com/RodneyShag

package _8_08_Permutations_with_Dups;

import java.util.*;

public class PermutationsWithDups {
    public static List<List<Integer>> permute(int[] array) {
        if (array == null || array.length == 0) {
            return new ArrayList<>();
        }
        Set<List<Integer>> solutions = new HashSet<>();
        permute(array, 0, new boolean[array.length], solutions, new ArrayList<>());
        return new ArrayList<>(solutions);
    }

    private static void permute(int[] array, int index, boolean[] used, Set<List<Integer>> solutions, List<Integer> list) {
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
