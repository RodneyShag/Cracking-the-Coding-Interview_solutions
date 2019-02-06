package _8_11_Coins;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 8.11: Coins\n");
        test(100);
        test(5);
    }

    private static void test(int n) {
        System.out.format("# of ways to make %3d cents (Using Quarters, Dimes, Nickels, Pennies) = %d\n", n, Coins.makeChange(n));
    }
}
