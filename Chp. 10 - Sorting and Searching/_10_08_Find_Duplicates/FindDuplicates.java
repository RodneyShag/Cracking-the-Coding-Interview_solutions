package _10_08_Find_Duplicates;

import java.util.BitSet;

// - 4 KB = 4096 Bytes = (4096 * 8) Bits > 32000, so 4 KB bit vector should be enough to hold 32,000 bits.
// - Using BitSet instead of HashMap since we have limited memory.

public class FindDuplicates {
    public static void checkDuplicates(int[] array) {
        BitSet bitset = new BitSet(32000);
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            if (bitset.get(num)) {
                System.out.print(num + " ");
            } else {
                bitset.set(num);
            }
        }
    }
}
