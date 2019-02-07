package _5_3_Flip_Bit_to_Win;

public class FlipBitToWin {
    public static int flipBit(int n) {
        int numBits = Integer.BYTES * 8;
        if (n == -1) { // no 0s in bit representation of number
            return numBits;
        }

        int prevLength = 0;
        int currLength = 0;
        int maxLength = 1;

        /* set "currLength" as # of trailing 1s */
        int i = 0;
        while (getBit(n, i)) {
            currLength++;
            i++;
        }

        /* Continue iterating through number */
        for (  ; i < numBits; i++) {
            if (getBit(n, i)) {
                currLength++;
            } else {
                prevLength = currLength;
                currLength = 0;
            }
            maxLength = Math.max(maxLength, currLength + 1 + prevLength);
        }
        return maxLength;
    }

    private static boolean getBit(int num, int bit) {
        return (num & (1 << bit)) != 0;
    }
}

//  Time Complexity: O(b) where b is number of bits in int.
// Space Complexity: O(1)
