// github.com/RodneyShag

package _16_07_Number_Max;

/* Finds max of 2 numbers without using if-else, comparison operators */
public class NumberMax {
    private static int flip(int bit) {
        return 1 ^ bit;
    }

    /* Returns 0 if a is negative, 1 if positive */
    public static int sign(int a) {
        return flip(a >>> 31); // >>> is unsigned right shift
    }

    /* Overflow of "a-b" will cause incorrect results */
    public static int max(int a, int b) {
        int k = sign(a - b);
        return k*a + flip(k)*b; // cool trick
    }

    /* This version solves overflow problem. From website solutions */
    public static int max2(int a, int b) {
        int difSigns = sign(a) ^ sign(b);
        int k = difSigns * sign(a) + flip(difSigns) * sign(a-b); // if a,b have different signs, we simply set k = sign(a)
        return k*a + flip(k)*b; 
    }
}
