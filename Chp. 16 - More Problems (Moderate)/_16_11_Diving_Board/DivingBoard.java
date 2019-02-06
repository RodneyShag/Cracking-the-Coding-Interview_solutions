package _16_11_Diving_Board;

import java.util.ArrayList;

public class DivingBoard {
    public static ArrayList<Integer> allLengths(int k, int shorter, int longer) {
        ArrayList<Integer> lengths = new ArrayList<>();
        for (int numShorter = 0; numShorter <= k; numShorter++) {
            int numLonger = k - numShorter;
            int length = numShorter * shorter + numLonger * longer;
            lengths.add(length);
        }
        return lengths;
    }
}
