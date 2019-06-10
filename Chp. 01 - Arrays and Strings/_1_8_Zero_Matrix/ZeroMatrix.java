package _1_8_Zero_Matrix;

// Solutions                   Runtime    Space    
// -----------------------------------------------
// 1. Using 2 arrays           O(m * n)   O(m + n)
// 2. Using input as storage   O(m * n)   O(1)             

public class ZeroMatrix {
    
    // Algorithm
    //
    // 1. Create a boolean array to save which rows have 0s.
    // 2. Repeat above step for columns.
    // 3. Loop through 2-d grid to figure out which rows & columns have a 0.
    // 4. Re-loop through 2-d grid and set whichever entries are necessary to 0.

    public static void solution1(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        // Loop through 2-d grid to figure out which rows & columns have a 0
        boolean[] rows = new boolean[M];
        boolean[] cols = new boolean[N];
        for (int row = 0; row < M; row++) {
            for (int col = 0; col < N; col++) {
                if (grid[row][col] == 0) {
                    rows[row] = true;
                    cols[col] = true;
                }
            }
        }

        // Re-loop through 2-d matrix and set whichever entries are necessary to 0
        for (int row = 0; row < M; row++) {
            for (int col = 0; col < N; col++) {
                if (rows[row] == true || cols[col] == true) {
                    grid[row][col] = 0;
                }
            }
        }
    }

    // Algorithm
    //
    // - To achieve an O(1) space solution, instead of using 2 new boolean arrays as in above solution, we will
    // use the array itself as storage. Specifically, we will use the 0th row and 0th column as our 2 arrays.
    // - To be able to overwrite the values in the 0th row and 0th col, we will process them first.
    //
    // 1. Check if row 0 has a 0. Save this info for later.
    // 2. Check if col 0 has a 0. Save this info for later.
    // 3. Use row 0 and col 0 as storage. Loop through grid and save which rows and columns have 0s.
    // 4. Zero out the necessary cells in grid (except for 0th row and 0th col).
    // 5. Zero out the necessary cells in row 0.
    // 6. Zero out the necessary cells in col 0.

    public static void solution2(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Check if row 0 has a 0. Save this info for later.
        boolean row0Has0 = false;
        for (int col = 0; col < cols; col++) {
            if (grid[0][col] == 0) {
                row0Has0 = true;
            }
        }

        // Check if col 0 has a 0. Save this info for later.
        boolean col0Has0 = false;
        for (int row = 0; row < rows; row++) {
            if (grid[row][0] == 0) {
                col0Has0 = true;
            }
        }
        
        // Use row 0 and col 0 as storage.
        // Loop through grid and save which rows and columns have 0s. 
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 0) {
                    grid[row][0] = 0;
                    grid[0][col] = 0;
                }
            }
        }
        
        // Zero out the necessary cells in grid (except for 0th row and 0th col).
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (grid[row][0] == 0 || grid[0][col] == 0) {
                    grid[row][col] = 0;
                }
            }
        }
        
        // Zero out the necessary cells in row 0.
        if (row0Has0) {
            for (int col = 0; col < cols; col++) {
                grid[0][col] = 0;
            }
        }
        
        // Zero out the necessary cells in col 0.
        if (col0Has0) {
            for (int row = 0; row < rows; row++) {
                grid[row][0] = 0;
            }
        }
    }
}
