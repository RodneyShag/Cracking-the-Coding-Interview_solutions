package _16_11_Diving_Board;

import java.util.*;

public class DivingBoard {
    public static List<Integer> allLengths(int k, int shorter, int longer) {
        List<Integer> lengths = new ArrayList<>();
        for (int numShorter = 0; numShorter <= k; numShorter++) {
            int numLonger = k - numShorter;
            int length = numShorter * shorter + numLonger * longer;
            lengths.add(length);
        }
        return lengths;
    }
}
