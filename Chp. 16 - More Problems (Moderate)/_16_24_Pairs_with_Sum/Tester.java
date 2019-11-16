// github.com/RodneyShag

package _16_24_Pairs_with_Sum;

import java.util.Arrays;
import java.util.HashSet;

public class Tester {
    public static void main(String[] args) {
        System.out.print("*** Test 16.24: Pairs with Sum");

        /* 2-sum: No duplicates in array */
        testNoDuplicates(new int[]{ 2, 3, 7, 6, 9, 8, 1, 4, 5 }, 7);

        /* 2-sum: Duplicates in array */
        testWithDuplicates(new int[]{ 5, 2, 7, 3, 1, 5, 7, 7 }, 12);
    }

    private static void testNoDuplicates(int[] array, int value) {
        System.out.println("\n\narray (no duplicates): " + Arrays.toString(array));
        System.out.print("pairs: ");
        PairsWithSum.twoSum_NoDuplicatesExist(array, value);
    }

    private static void testWithDuplicates(int[] array, int value) {
        System.out.println("\n\narray (with duplicates): " + Arrays.toString(array));

        /* Print all pairs summing to "value" */
        System.out.print("all pairs: ");
        PairsWithSum.twoSum_PrintDuplicates(array, value);

        /* Print unique pairs summing to "value" */
        System.out.print("\nunique pairs: ");
        HashSet<Pair> pairs = PairsWithSum.twoSum_DontPrintDuplicates(array, value);
        for (Pair pair : pairs) {
            System.out.print(pair);
        }
    }
}
