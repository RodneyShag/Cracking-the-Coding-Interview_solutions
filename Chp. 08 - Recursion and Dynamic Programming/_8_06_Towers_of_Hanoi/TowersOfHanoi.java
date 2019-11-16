// github.com/RodneyShag

package _8_06_Towers_of_Hanoi;

public class TowersOfHanoi {
    public static void moveDisks(int n, Tower origin, Tower destination, Tower buffer) {
        if (n > 0) {
            moveDisks(n - 1, origin, buffer, destination);
            moveTop(origin, destination);
            moveDisks(n - 1, buffer, destination, origin);
        }
    }

    /* We teach it how to move 1 disk. Therefore it can recursively move n disks */
    private static void moveTop(Tower origin, Tower destination) {
        Integer disk = origin.pop();
        destination.push(disk);
        System.out.println("Move disk " + disk + " from Tower " + origin.towerNum + " to Tower " + destination.towerNum);
    }
}
