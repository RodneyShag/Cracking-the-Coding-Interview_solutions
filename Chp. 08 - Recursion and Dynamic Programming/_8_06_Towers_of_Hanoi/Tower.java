package _8_06_Towers_of_Hanoi;

import java.util.*;

// It's just a stack, including 1) Error Checking 2) tower number
class Tower {
    private Deque<Integer> disks; // use deque as a stack
    public int towerNum;

    public Tower(int towerNum) {
        disks = new ArrayDeque<>();
        this.towerNum = towerNum;
    }

    // Can only push a disk onto a stack if there isn't already a smaller disk on it
    public void push(int d) {
        if (!disks.isEmpty() && disks.peek() <= d) {
            System.out.println("Error Placing Disk " + d);
        } else {
            disks.push(d);
        }
    }

    // Can only pop from a non-empty stack
    public Integer pop() {
        if (disks.isEmpty()) {
            return null;
        } else {
            return disks.pop();
        }
    }
}
