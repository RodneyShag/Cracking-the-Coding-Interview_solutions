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
	 * - Must start in top right (as we did) or bottom left
	 * - Always either move down (eliminating current row), or move left (eliminating current col)
	 */
	public static boolean findElement(int [][] matrix, int elem){
		int numRows = matrix.length;
		
		/* Start off at top right */
		int row = 0; 
		int col = matrix[0].length - 1;
		
		while(row < numRows && col >= 0){
			if (matrix[row][col] == elem)
				return true;
			else if (matrix[row][col] > elem)
				col--;
			else
				row++;
		}
		return false;
	}
}
