// github.com/RodneyShag

package _10_02_Group_Anagrams;

import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** 10.2: Group Anagrams");
        String[] array1 = {"hello", "hi", "ih", "obb", "bob", "helol", "olleh", "god", "loleh", "lolhe", "asd", "nwr", "gsegae", "fesf"};
        String[] array2 = array1.clone();
        String[] array3 = array1.clone();

        System.out.println("\nInput: " + Arrays.toString(array1) + "\n");
        test(array2);
        test2(array3);
    }

    private static void test(String[] array) {
        GroupAnagrams.groupAnagrams(array);
        System.out.println(Arrays.toString(array));
    }
   
    private static void test2(String[] array) {
        GroupAnagrams.groupAnagrams2(array);
        System.out.println(Arrays.toString(array));
    }
}
