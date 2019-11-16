// github.com/RodneyShag

package _10_05_Sparse_Search;

import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** 10.5: Sparse Search\n");
        String[] words = { "at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "" };
        System.out.println("Array: " + Arrays.toString(words));
        test(words, "at");
        test(words, "ball");
        test(words, "car");
        test(words, "dad");
        test(words, "food");
    }

    private static void test(String[] words, String word) {
        System.out.format("\n%5s is at index: %d", word, SparseSearch.find(words, word));
    }
}
