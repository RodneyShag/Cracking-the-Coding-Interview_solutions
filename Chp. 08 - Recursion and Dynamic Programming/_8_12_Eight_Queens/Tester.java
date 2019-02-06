package _8_12_Eight_Queens;

import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 8.12: Eight Queens\n");
        ArrayList<Integer[]> results = EightQueens.placeQueens();
        for (Integer[] board : results) {
            printBoard(board);
        }
    }

    private static void printBoard(Integer[] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.print("(" + i + "," + board[i] + ") ");
        }
        System.out.println();
    }
}
