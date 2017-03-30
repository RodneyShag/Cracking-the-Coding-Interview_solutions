package chapter18;

/* Find maximum subsquare with black borders
 * 
 * Solutions        Runtime     Preference
 * ----------------------------------------------------------------------
 * 1) Brute Force   O(n^4)      Do this solution first
 * 2) Pre-process   O(n^3)      If time permits, optimize to this solution
 */
public class EighteenPoint11 {
	
	public static Subsquare findLargestSubsquare(int[][] matrix) { // outer loop adds O(n) multiplier to runtime
		for (int dimension = matrix.length; dimension >= 1; dimension--) {
			Subsquare subsquare = findSubsquare(matrix, dimension);
			if (subsquare != null) {
				return subsquare;
			}
		}
		return null;
	}
	
	private static Subsquare findSubsquare(int[][] matrix, int length) { // the 2 for loops add O(n^2) multiplier to runtime
		int wiggleRoom = matrix.length - length + 1;
	  
		for (int startRow = 0; startRow < wiggleRoom; startRow++) {
			for (int startCol = 0; startCol < wiggleRoom; startCol++) {
				if (isValidSquare(matrix, startRow, startCol, length)) {
					return new Subsquare(startRow, startCol, length);
				}
			}
		}
		return null;
	}
	
	// in int[][] matrix, 1 is BLACK, 0 is WHITE
	private static boolean isValidSquare(int[][] matrix, int row, int col, int length) { // runs in O(n) time (since 1 for loop)
		int rows = matrix.length;
		int cols = matrix[0].length;
		  
		if (row < 0 || row + length > rows || col < 0 || col + length > cols) {
			return false;
		}
		
		for (int i = 0; i < length; i++) {
			if (matrix[row + i][col] == 0) {                     // check left column
				return false;
			} else if (matrix[row + i][col + length - 1] == 0) { // check right column
				return false;
			}
		}
		for (int i = 1; i < length - 1; i++) {
			if (matrix[row][col + i] == 0) {           			 // check top row
				return false;
			} else if (matrix[row + length - 1][col + i] == 0) { // check bottom row
				return false;
			}
		}
		return true;
	}
	
	/******************/
	/*** Solution 2 ***/
	/******************/
	
	public static Cell[][] preprocessMatrix(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		Cell[][] preprocessed = new Cell[matrix.length][matrix.length];
		for (int row = rows - 1; row >= 0; row--) {
			for (int col = cols - 1; col >= 0; col--) {
				preprocessed[row][col] = new Cell(0,0);
				if (matrix[row][col] == 1) {
					preprocessed[row][col].blacksRight = 1 + ((col + 1 < cols) ? preprocessed[row][col + 1].blacksRight : 0);
					preprocessed[row][col].blacksDown  = 1 + ((row + 1 < rows) ? preprocessed[row + 1][col].blacksDown  : 0);
				}
			}
		}
		return preprocessed;
	}
	
	public static Subsquare findLargestSubsquare2(int[][] matrix) { // runs in O(n) time (since 1 for loop)
		Cell [][] processed = preprocessMatrix(matrix);
		for (int dimension = processed.length; dimension >= 1; dimension--) {
			Subsquare subsquare = findSubsquare2(processed, dimension);
			if (subsquare != null) {
				return subsquare;
			}
		}
		return null;
	}
	
	private static Subsquare findSubsquare2(Cell [][] processed, int length) { // runs in O(n^2) time (since 2 for loops)
		int wiggleRoom = processed.length - length + 1;
	  
		for (int startRow = 0; startRow < wiggleRoom; startRow++) {
			for (int startCol = 0; startCol < wiggleRoom; startCol++) {
				if (isValidSquare2(processed, startRow, startCol, length)) {
					return new Subsquare(startRow, startCol, length);
				}
			}
		}
		return null;
	}
	
	private static boolean isValidSquare2(Cell[][] cellMatrix, int row, int col, int length) { // runs in O(1) time
		Cell topLeft     = cellMatrix[row][col];
		Cell topRight    = cellMatrix[row][col + length - 1];
		Cell bottomLeft  = cellMatrix[row + length - 1][col];
		Cell bottomRight = cellMatrix[row + length - 1][col + length - 1];
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
