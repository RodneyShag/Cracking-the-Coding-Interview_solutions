package _10_09_Sorted_Matrix_Search;

// Find element in sorted 2-D array (sorted by row and col)
//
// Solutions                                    Runtime       Preference
// ---------------------------------------------------------------------------
// 0) Binary Search Every Row                   O(m log n)    Worth Mentioning
// 1) Iterative from Top-Right to Bottom-Left   O(m+n)        Favorite

public class SortedMatrixSearch {
    // Solution 1 - On every step, eliminate a row or a column.
    // - Start in top right corner
    // - Always either move down (eliminating current row), or move left (eliminating current col)
    // - Alternate solution: start in bottom left and move to top right
    public static boolean findElement(int[][] grid, int elem) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Start at top right corner
        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {
            if (grid[row][col] == elem) {
                return true;
            } else if (grid[row][col] > elem) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
