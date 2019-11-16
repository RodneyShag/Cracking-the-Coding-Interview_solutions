// github.com/RodneyShag

package _5_6_Conversion;

import common.BitFunctions;

public class Conversion {
    public static int bitsRequired(int A, int B) {
        int xored = A ^ B;
        return BitFunctions.numOnes(xored);
    }
}
