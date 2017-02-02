package chapter18;

/* Find maximum subsquare with black borders
* 
* Solutions              Runtime                          Preference
* ------------------------------------------------------------------------
* 1) Brute Force         O(n^6)                           Worth mentioning
* 2) Pre-process         O(n^4)                           Worth mentioning
* 3) maxSubarray trick   O(R^2*C) (R = rows, C = cols)    Favorite
*/
public class EighteenPoint12 {
	
	/**************/
	/* Solution 1 */
	/**************/
	
	public static int findLargestSubmatrix(int[][] matrix) {
		int maxArea = Integer.MIN_VALUE;
	    int rows = matrix.length;
	    int cols = matrix[0].length;
	   
	    for (int rowStart = 0; rowStart < rows; rowStart++) {
	    	for (int rowEnd = rowStart; rowEnd < rows; rowEnd++) {
	    		for (int colStart = 0; colStart < cols; colStart++) {
	    			for (int colEnd = colStart; colEnd < cols; colEnd++) {
	    				maxArea = Math.max(maxArea, getSum(matrix, rowStart, rowEnd, colStart, colEnd));
	    			}
	    		}
	    	}
	    }
	    return maxArea;
	}
	  
	public static int getSum(int[][] matrix, int rowStart, int rowEnd, int colStart, int colEnd) { // runs in O(n^2) time
		int sum = 0;
		for (int row = rowStart; row <= rowEnd; row++) {
			for (int col = colStart; col <= colEnd; col++) {
				sum += matrix[row][col];
			}
		}
		return sum;
	}	  
	
	/**************/
	/* Solution 2 */
	/**************/
	
	public static int findLargestSubmatrix2(int[][] matrix) {
		int [][] processed = preprocess(matrix);
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

	/* For each element at (x,y), we store the sum of all values from (0,0) to (x,y) */
    public static int[][] preprocess(int[][] matrix) {
    	if (matrix == null)
    		return null;
    	int rows = matrix.length;
    	int cols = matrix[0].length;
    	
        int[][] processed = new int[rows][cols];
        processed[0][0] = matrix[0][0];
        for (int row = 1; row < rows; row++) {
            processed[row][0] = processed[row - 1][0] + matrix[row][0];
        }
        for (int col = 1; col < cols; col++) {
            processed[0][col] = processed[0][col - 1] + matrix[0][col];
        }
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                processed[row][col] = processed[row - 1][col] + 
	                                  processed[row][col - 1] - 
	                                  processed[row - 1][col - 1] + 
	                                  matrix[row][col];
            }
        }
        return processed;
    }
    
	public static int getSum2(int[][] processed, int rowStart, int rowEnd, int colStart, int colEnd) { // runs in O(1) since matrix was preprocessed
		return processed[rowEnd][colEnd] - 
			   processed[rowStart][colEnd] - 
			   processed[rowEnd][colStart] + 
			   processed[rowStart][colStart];
	}

	/**************/
	/* Solution 3 */
	/**************/
	
	public static int findLargestSubmatrix3(int [][] matrix) {	
		int rows = matrix.length;
		int cols = matrix[0].length;
		int maxSum = 0;
		for (int rowStart = 0; rowStart < rows; rowStart++){
			int [] partialSum = new int[cols];			
			for (int rowEnd = rowStart; rowEnd < rows; rowEnd++) {

				/* Update partialSum */
				for (int col = 0; col < cols; col++) {
					partialSum[col] += matrix[rowEnd][col];
				}
				
				int sum = maxSubArray(partialSum);
				maxSum = Math.max(sum, maxSum);
			}
		}
		return maxSum;
	}
	
	public static int maxSubArray(int [] array) {
		int maxSum = 0;
		int runningSum = 0;
		for (int i = 0; i < array.length; i++) {
			runningSum += array[i];
			maxSum = Math.max(maxSum, runningSum);
			if (runningSum < 0)
				runningSum = 0;
		}
		return maxSum;
	}
}
