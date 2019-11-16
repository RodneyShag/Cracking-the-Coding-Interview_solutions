// github.com/RodneyShag

package _17_05_Letters_and_Numbers;

import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 17.5: Letters and Numbers\n");
        test("aaaa11a11aa1aa1aaaaa");
        test("a11a1");
    }

    private static void test(String str) {
        System.out.print(str + " - ");
        char[] array = str.toCharArray();
        char[] result = LettersAndNumbers.maxSubarray(array);
        if (result != null) {
            System.out.println(Arrays.toString(result));
        } else {
            System.out.println("null result");
        }
    }
}
