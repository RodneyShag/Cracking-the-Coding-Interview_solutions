// github.com/RodneyShag

package _8_12_Eight_Queens;

import java.util.*;

public class EightQueens {
    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        Set<Integer> cols = new HashSet(); // columns   |
        Set<Integer> d1 = new HashSet();   // diagonals \
        Set<Integer> d2 = new HashSet();   // diagonals /

        List<List<String>> solutions = new ArrayList();
        placeQueens(board, n, solutions, 0, cols, d1, d2);
        return solutions;
    }

    private static void placeQueens(char[][] board, int n, List<List<String>> solutions, int row,
                             Set<Integer> cols, Set<Integer> d1, Set<Integer> d2) {
        if (row == n) {
            solutions.add(makeSolutionBoard(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            int diag1 = col - row;
            int diag2 = col + row;
            if (cols.contains(col) || d1.contains(diag1) || d2.contains(diag2)) {
                continue;
            }
            // put queen on board
            board[row][col] = 'Q';
            cols.add(col);
            d1.add(diag1);
            d2.add(diag2);

            placeQueens(board, n, solutions, row + 1, cols, d1, d2);

            // remove queen from board
            cols.remove(col);
            d1.remove(diag1);
            d2.remove(diag2);
            board[row][col] = '.';
        }
    }

    private static List<String> makeSolutionBoard(char[][] board) {
        List<String> solution = new ArrayList();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }
}
