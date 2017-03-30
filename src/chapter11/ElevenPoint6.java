package chapter11;

/* Find element in sorted 2-D array (sorted by row and col)
 * 
 * Solutions                                    Runtime       Preference
 * ---------------------------------------------------------------------------
 * 0) Binary Search Every Row                   O(m log n)    Worth Mentioning
 * 1) Iterative from Top-Right to Bottom-Left   O(m+n)        Favorite
 */
public class ElevenPoint6 {
	
	/* Solution 1 - On every step, eliminate a row or a column.
	 * - Start in top right corner
	 * - Always either move down (eliminating current row), or move left (eliminating current col)
	 * - Alternate solution: start in bottom left and move to top right
	 */
	public static boolean findElement(int [][] matrix, int elem) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        /* Start at top right corner */
        int row = 0;
        int col = cols - 1;
		
		while (row < rows && col >= 0) {
			if (matrix[row][col] == elem) {
				return true;
			} else if (matrix[row][col] > elem) {
				col--;
			} else {
				row++;
			}
		}
		return false;
	}
}
