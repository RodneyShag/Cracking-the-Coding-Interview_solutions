package _16_05_Factorial_Zeros;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 16.5: Factorial Zeros");
        test(8);
        test(9);
        test(10);
        test(20);
    }

    private static void test(int n) {
        System.out.format("\n%2d! = %20d   # Trailing 0s = %d", n, calculateFactorial(n), FactorialZeros.numTrailingZeros(n));
    }

    private static long calculateFactorial(long num) {
        if (num > 20) {
            return -1; // since result may cause overflow
        }
        long result = 1;
        while (num > 1) {
            result *= num;
            num--;
        }
        return result;
    }
}
