package chapter11;

public class ElevenPoint6 {
	/* Solution 0 - Binary search on every row so it's O(m log n) time */
	
	/* Solution 1 - On every step, eliminate a row or a column.
	 * - Must start in top right (as we did) or bottom left
	 * - Always either move down (eliminating current row), or move left (eliminating current col)
	 */
	public static boolean findElement(int [][] matrix, int elem){
		int row = 0; 
		int col = matrix[0].length - 1;
		while(row < matrix.length && col >= 0){
			if (matrix[row][col] == elem)
				return true;
			else if (matrix[row][col] > elem)
				col--;
			else
				row++;
		}
		return false;
	}
	
	/* Solution 2 - Just glance at the solution.
	 * - Read and understand the algorithm conceptually. My code can kinda follow logically from this. Binary Search on Diagonal is tricky part.
	 * - Book's code is overly complicated. It created a Coordinate class which I probably wouldn't use (but could mention in interview).
	 * */
	
}
