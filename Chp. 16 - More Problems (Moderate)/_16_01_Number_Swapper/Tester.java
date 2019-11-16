// github.com/RodneyShag

package _16_01_Number_Swapper;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 16.1: Number Swapper");
        test(2, 4);
        test(3, 5);
    }

    private static void test(int a, int b) {
        System.out.println("\nOriginal: a = " + a + "  b = " + b);
        NumberSwapper.swap1(a, b);
        NumberSwapper.swap2(a, b);
    }
}
