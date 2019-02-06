package _17_06_Count_of_2s;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 17.6: Count of 2s\n");
        test(5);
        test(99);
    }

    private static void test(int n) {
        System.out.format("(from 1 to %2d): %2d\n", n, CountOf2s.count2s(n));
    }
}
