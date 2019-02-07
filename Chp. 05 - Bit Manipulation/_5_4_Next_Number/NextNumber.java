package _5_4_Next_Number;

import common.BitFunctions;

/* The algorithm is from the book, but my code is completely different. I like my version better.
 * Memorize the algorithm, not the code */

public class NextNumber {
    public static int getNext(int num) {
        int indexOfZero = -1;
        int c0 = 0; //count of 0's. We never use this, but it would be useful to have in an interview.
        int c1 = 0; // count of 1's

        /* Step 1 - Search from right to left to find first 0 with a 1 anywhere to the right of it, and set it to 1 */
        for (int i = 0; i < 32; i++) {
            boolean bit = BitFunctions.getBit(num, i);
            if (!bit && c1 > 0) {
                indexOfZero = i;
                break;
            }
            if (bit) {
                c1++;
            } else {
                c0++;
            }
        }
		if (indexOfZero == -1) {
            return -1; // Error. Could happen on a 32-bit binary number like 1111....0000,
                       // or any number which is a bunch of 1's followed by a bunch of zeros 
        }
        num = BitFunctions.setBit(num, indexOfZero);

        /* Step 2 - Clear bits to the right of the index. */
        num = BitFunctions.clearBitsIthrough0(num, indexOfZero - 1);

        /* Step 3 - Add in c1 - 1 ones in least significant spots ` */
        for (int i = 0; i < c1 - 1; i++) {
            num = BitFunctions.setBit(num, i);
        }
        return num;
    }

    public static int getPrev(int num) {
        int indexOfOne = -1;
        int c0 = 0; // count of 0's. We never use this, but it would be useful to have in an interview.
        int c1 = 0; // count of 1's.

        /* Step 1 - Search from right to left to find first 1 with a 0 anywhere to the right of it, and set it to 0 */
        for (int i = 0; i < 32; i++) {
            boolean bit = BitFunctions.getBit(num, i);
            if (bit && c0 > 0) {
                indexOfOne = i;
                break;
            }
            if (bit) {
                c1++;
            } else {
                c0++;
            }
        }
        if (indexOfOne == -1) {
            return -1; // Error. Could happen on a 32-bit binary number like 0000....1111,
                       // or any number which is a bunch of 0's followed by a bunch of 1's 
        }
        num = BitFunctions.clearBit(num, indexOfOne);

        /* Step 2 - Clear bits to the right of the index. */
        num = BitFunctions.clearBitsIthrough0(num, indexOfOne - 1);

        /* Step 3 - Add in c1 + 1 ones immediately to the right of the cleared bit */
        int onesToAdd = c1 + 1;
        int i = indexOfOne - 1;
        while (onesToAdd > 0) {
            num = BitFunctions.setBit(num, i);
            onesToAdd--;
            i--;
        }
        return num;
    }
}
