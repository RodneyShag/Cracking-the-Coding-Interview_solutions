package _17_24_Max_Submatrix;

// Find maximum subsquare with black borders
// 
// Solution               Runtime                          Preference
// ------------------------------------------------------------------------
// 1) Brute Force         O(R^3*C^3)                       Worth mentioning
// 2) Pre-process         O(R^2*C^2)                       Worth mentioning
// 3) maxSubarray trick   O(R^2*C) (R = rows, C = cols)    Favorite

public class MaxSubmatrix {

    /**************/
    /* Solution 1 */
    /**************/

    public static int findLargestSubmatrix(int[][] grid) {
        int maxArea = Integer.MIN_VALUE;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int rowStart = 0; rowStart < rows; rowStart++) {
            for (int rowEnd = rowStart; rowEnd < rows; rowEnd++) {
                for (int colStart = 0; colStart < cols; colStart++) {
                    for (int colEnd = colStart; colEnd < cols; colEnd++) {
                        maxArea = Math.max(maxArea, getSum(grid, rowStart, rowEnd, colStart, colEnd));
                    }
                }
            }
        }
        return maxArea;
    }

    public static int getSum(int[][] grid, int rowStart, int rowEnd, int colStart, int colEnd) { // runs in O(n^2) time
        int sum = 0;
        for (int r = rowStart; r <= rowEnd; r++) {
            for (int c = colStart; c <= colEnd; c++) {
                sum += grid[r][c];
            }
        }
        return sum;
    }

    /**************/
    /* Solution 2 */
    /**************/

    public static int findLargestSubmatrix2(int[][] grid) {
        int[][] processed = preprocess(grid);
        int maxArea = Integer.MIN_VALUE;
        int rows = processed.length;
        int cols = processed[0].length;

        for (int rowStart = 0; rowStart < rows; rowStart++) {
            for (int rowEnd = rowStart; rowEnd < rows; rowEnd++) {
                for (int colStart = 0; colStart < cols; colStart++) {
                    for (int colEnd = colStart; colEnd < cols; colEnd++) {
                        maxArea = Math.max(maxArea, getSum2(processed, rowStart, rowEnd, colStart, colEnd));
                    }
                }
            }
        }
        return maxArea;
    }

    // For each element at (x,y), we store the sum of all values from (0,0) to (x,y)
    private static int[][] preprocess(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] processed = new int[rows][cols];
        processed[0][0] = grid[0][0];
        for (int r = 1; r < rows; r++) {
            processed[r][0] = processed[r - 1][0] + grid[r][0];
        }
        for (int c = 1; c < cols; c++) {
            processed[0][c] = processed[0][c - 1] + grid[0][c];
        }
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                processed[row][col] = processed[row - 1][col] +
                                      processed[row][col - 1] -
                                      processed[row - 1][col - 1] +
                                      grid[row][col];
            }
        }
        return processed;
    }
    
    private static int getSum2(int[][] processed, int rowStart, int rowEnd, int colStart, int colEnd) { // runs in O(1) since matrix was preprocessed
        return processed[rowEnd][colEnd] - 
               processed[rowStart][colEnd] - 
               processed[rowEnd][colStart] + 
               processed[rowStart][colStart];
    }

    /**************/
    /* Solution 3 */
    /**************/

    public static int findLargestSubmatrix3(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxSum = 0;
        for (int rowStart = 0; rowStart < rows; rowStart++) {
            int[] partialSum = new int[cols];
            for (int rowEnd = rowStart; rowEnd < rows; rowEnd++) {
                for (int col = 0; col < cols; col++) {
                    partialSum[col] += grid[rowEnd][col];
                }
                int sum = maxSubArray(partialSum);
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    private static int maxSubArray(int[] A) {
        int maxEndingHere = A[0];
        int maxSum = A[0];
        for (int i = 1; i < A.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
            maxSum = Math.max(maxSum, maxEndingHere);
        }
        return maxSum;
    }
}
