// github.com/RodneyShag

package _8_06_Towers_of_Hanoi;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 8.6: Towers of Hanoi\n");
        int numTowers = 3;
        int numDisks = 4; // can make this bigger
        Tower[] towers = new Tower[numTowers];
        for (int i = 0; i < numTowers; i++) {
            towers[i] = new Tower(i); // don't forget. We have to do this too!
        }
        for (int i = numDisks; i > 0; i--) {
            towers[0].push(i);
        }
        TowersOfHanoi.moveDisks(numDisks, towers[0], towers[2], towers[1]);
    }
}
