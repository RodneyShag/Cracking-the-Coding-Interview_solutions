// github.com/RodneyShag

package _17_18_Shortest_Supersequence;

public class Range {
    Integer min;
    Integer max;

    Range(int min, int max) {
        this.min = min;
        this.max = max;
    }

    Range(Range other) {
        min = other.min;
        max = other.max;
    }

    void setRange(Range other) {
        min = other.min;
        max = other.max;
    }

    boolean isShorterThan(Range other) {
        return size() < other.size();
    }

    int size() {
        return max - min + 1;
    }

    @Override
    public String toString() {
        return "[" + min + "," + max + "]";
    }
}
