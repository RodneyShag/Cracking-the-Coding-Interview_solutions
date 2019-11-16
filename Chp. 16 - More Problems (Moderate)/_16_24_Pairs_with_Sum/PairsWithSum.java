// github.com/RodneyShag

package _16_24_Pairs_with_Sum;

import java.util.HashMap;
import java.util.HashSet;

// Good question to ask. Given { 1, 5, 1, 5 }, what do you want our output be?
// 1) {1,5}
// 2) {1,5}, {5,1}
// 3) {1,5}, {1,5}, {5,1}, {5,1}

public class PairsWithSum {
    public static void twoSum_NoDuplicatesExist(int[] array, int sum) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : array) {
            if (set.contains(sum - num)) {
                printPair(num, sum - num);
            }
            set.add(num);
        }
    }

    public static void twoSum_PrintDuplicates(int[] array, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            if (map.containsKey(sum - num)) {
                int count = map.get(sum - num); // to account for duplicates
                while (count-- > 0) {
                    printPair(sum - num, num);
                }
            }
            map.merge(num, 1, Integer::sum);
        }
    }

    /* Assuming interviewer considers pair {1,5} same as {5,1}. We make them the same in Pair class */
    public static HashSet<Pair> twoSum_DontPrintDuplicates(int[] array, int sum) {
        HashSet<Pair> pairs = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            if (set.contains(sum - num)) {
                pairs.add(new Pair(num, sum - num));
            }
            set.add(num);
        }
        return pairs;
    }

    private static void printPair(int a, int b) {
        System.out.print("(" + a + "," + b + ") ");
    }
}
