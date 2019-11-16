// github.com/RodneyShag

package _17_23_Max_Black_Square;

// Tricks:
// 1) Preprocess the grid
// 2) Have "Cell" and "Subsquare" classes
// 3) Search largest squares first

public class MaxBlackSquare {
    public static Subsquare findLargestSubsquare(int[][] grid) { // O(n) * runtime of findSubSquare()
        Cell[][] processed = preprocessGrid(grid);
        for (int dimension = processed.length; dimension >= 1; dimension--) {
            Subsquare ss = findSubsquare(processed, dimension);
            if (ss != null) {
                return ss;
            }
        }
        return null;
    }

    public static Cell[][] preprocessGrid(int[][] grid) { // O(n^2)
        int rows = grid.length;
        int cols = grid[0].length;

        Cell[][] preprocessed = new Cell[rows][cols];
        for (int r = rows - 1; r >= 0; r--) {
            for (int c = cols - 1; c >= 0; c--) {
                preprocessed[r][c] = new Cell(0, 0);
                if (grid[r][c] == 1) {
                    preprocessed[r][c].blacksRight = 1 + ((c + 1 < cols) ? preprocessed[r][c + 1].blacksRight : 0);
                    preprocessed[r][c].blacksDown  = 1 + ((r + 1 < rows) ? preprocessed[r + 1][c].blacksDown  : 0);
                }
            }
        }
        return preprocessed;
    }

    private static Subsquare findSubsquare(Cell[][] cellMatrix, int length) { // O(n^2) (since 2 for loops)
        int wiggleRoom = cellMatrix.length - length;

        for (int r = 0; r <= wiggleRoom; r++) {
            for (int c = 0; c <= wiggleRoom; c++) {
                if (isValidSquare(cellMatrix, r, c, length)) {
                    return new Subsquare(r, c, length);
                }
            }
        }
        return null;
    }

    // r, c represent top-left corner of square
    private static boolean isValidSquare(Cell[][] cellMatrix, int r, int c, int length) { // O(1)
        Cell topLeft     = cellMatrix[r][c];
        Cell topRight    = cellMatrix[r][c + length - 1];
        Cell bottomLeft  = cellMatrix[r + length - 1][c];
        Cell bottomRight = cellMatrix[r + length - 1][c + length - 1];
        if (topLeft.blacksDown < length || topLeft.blacksRight < length) {
            return false;
        } else if (topRight.blacksDown < length || topRight.blacksRight < 1) {
            return false;
        } else if (bottomLeft.blacksDown < 1 || bottomLeft.blacksRight < length) {
            return false;
        } else if (bottomRight.blacksDown < 1 || bottomRight.blacksRight < 1) {
            return false;
        }
        return true;
    }
}

//  Time Complexity: O(n^3)
// Space Complexity: O(n^2)
