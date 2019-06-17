package _8_04_Power_Set;

import java.util.*;

public class PowerSet {
    public static List<List<Integer>> getSubsets(List<Integer> set) {
        List<List<Integer>> powerSet = new ArrayList<>();
        int max = (int) Math.pow(2, set.size());
        for (int i = 0; i < max; i++) { // this is the main trick
            List<Integer> subset = createSubset(set, i);
            powerSet.add(subset);
        }
        return powerSet;
    }

    private static List<Integer> createSubset(List<Integer> set, int num) {
        List<Integer> subset = new ArrayList<>();
        int indexInSet = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                subset.add(set.get(indexInSet));
            }
            indexInSet++;
            num = num >> 1;
        }
        return subset;
    }
}

// Time Complexity: O(2^n). Impossible to do better
