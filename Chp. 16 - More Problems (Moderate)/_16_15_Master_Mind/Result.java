// github.com/RodneyShag

package _16_15_Master_Mind;

public class Result {
    int directHits = 0;
    int pseudoHits = 0;

    @Override
    public String toString() {
        return ("(Direct Hits, Pseudo Hits) = (" + directHits + "," + pseudoHits + ")");
    }
}
