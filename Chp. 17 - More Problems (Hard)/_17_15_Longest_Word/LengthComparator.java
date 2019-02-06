package _17_15_Longest_Word;

import java.util.Comparator;

public class LengthComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return s2.length() - s1.length(); // sorting backwards to put longer words in front.
    }
}
