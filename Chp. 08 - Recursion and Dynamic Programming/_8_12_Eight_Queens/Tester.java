package _8_12_Eight_Queens;

import java.util.*;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 8.12: Eight Queens\n");
        List<List<String>> solution = EightQueens.solveNQueens(8);
        for (List<String> board : solution) {
            printBoard(board);
        }
    }

    private static void printBoard(List<String> board) {
        for (String str : board) {
            System.out.println(str);
        }
        System.out.println();
    }
}
