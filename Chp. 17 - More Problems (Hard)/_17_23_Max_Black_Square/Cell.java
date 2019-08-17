package _17_23_Max_Black_Square;

public class Cell { // public variables for simplicity
    int blacksRight = 0; // including itself
    int blacksDown  = 0; // including itself

    public Cell(int right, int down) {
        blacksRight = right;
        blacksDown  = down;
    }
}
