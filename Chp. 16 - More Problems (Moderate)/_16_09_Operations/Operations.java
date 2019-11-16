// github.com/RodneyShag

package _16_09_Operations;

public class Operations {
    public static int subtract(int a, int b) {
        return a + negate(b);
    }

    public static int multiply(int a, int b) {
        if (b > a) {
            return multiply(b, a); // since this will be faster
        }
        boolean negativeResult = (a > 0 && b < 0) || (a < 0 && b > 0);
        a = Math.abs(a);
        b = Math.abs(b);

        int result = 0;
        for (int i = 0; i < b; i++) {
            result += a; // the main algorithm. multiplication is just repeated addition
        }

        if (negativeResult) {
            result = negate2(result);
        }
        return result;
    }

    public static int divide(int a, int b) throws Exception {
        if (b == 0) {
            throw new Exception("Can't divide by 0");
        }
        boolean negativeResult = (a > 0 && b < 0) || (a < 0 && b > 0);
        a = Math.abs(a);
        b = Math.abs(b);

        int result = 0;
        int originalB = b;

        /* The main algorithm */
        while (b <= a) {
            b += originalB;
            result++;
        }

        if (negativeResult) {
            result = negate2(result);
        }
        return result;
    }

    private static int negate(int a) {
        return ~a + 1;
        // return (a ^ 0xFFFFFFFF) + 1; // Alternate solution (assumes 32-bit int)
    }

    /* Book's complicated way to negate */
    private static int negate2(int a) {
        int neg = 0;
        int d = (a < 0) ? 1 : -1;
        while (a != 0) {
            a += d;
            neg += d;
        }
        return neg;
    }
}
