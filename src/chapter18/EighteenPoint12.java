package chapter18;
/* Code is a combination of book and website solution */

/* Solution 1: O(n^6) time									//Do this in an interview
 * Solution 2: O(n^4) time (since we preprocess matrix)		//Do this in an interview
 * Solution 3: O(n^3) time (using maxSubarray trick)		//Mention this in an interview (It's not that hard to code though)
 */
public class EighteenPoint12 {

	  public static int findLargestSubmatrix(int[][] matrix) {
	      int maxArea = Integer.MIN_VALUE;
	      int rowCount = matrix.length;
	      int colCount = matrix[0].length;
	    
	      for (int r1 = 0; r1 < rowCount; ++r1) {
	          for (int r2 = r1; r2 < rowCount; ++r2) {
	              for (int c1 = 0; c1 < colCount; ++c1) {
	                  for (int c2 = c1; c2 < colCount; ++c2) {
	                	  maxArea = Math.max(maxArea, getSum(matrix, r1, r2, c1, c2));
	                  }
	              }
	          }
	      }
	      return maxArea;
	  }
	  
	  /* Use for a matrix that's not preprocessed */
	  public static int getSum(int[][] matrix, int r1, int r2, int c1, int c2) {
	      int sum = 0;
	      for (int r = r1; r <= r2; ++r) {
	          for (int c = c1; c <= c2; ++c) {
	              sum += matrix[r][c];
	          }
	      }
	      return sum;
	  }	  
	  
	  //Preprocess matrix to reduce getSum (O(n^2)) time to getSum2 which is O(1) time.
	  public static int[][] processMatrix(int[][] matrix){	//code mainly from book.
		  if (matrix == null) 
			  return null;
		  int[][] sumMatrix = new int[matrix.length][matrix[0].length];
		  for (int i = 0; i < matrix.length; i++){
			  for (int j = 0; j < matrix[0].length; j++){
				  /* Split up cases to avoid index out of bounds errors */
				  if (i == 0 && j == 0)
					  sumMatrix[0][0] = matrix[0][0];
				  else if (i == 0)
					  sumMatrix[0][j] = sumMatrix[0][j-1] + matrix[0][j];
				  else if (j == 0)
					  sumMatrix[i][0] = sumMatrix[i-1][0] + matrix[i][0];
				  else
					  sumMatrix[i][j] = sumMatrix[i][j-1] + sumMatrix[i-1][j] - sumMatrix[i-1][j-1] + matrix[i][j];	//this is for most elements.
			  }
		  }
		  return sumMatrix;
	  }
	  
	  /* Use on preprocessed matrix */
	  public static int getSum2(int[][] sumMatrix, int r1, int c1, int r2, int c2) {
	      return sumMatrix[r2][c2] - 
	              sumMatrix[r1][c2] - 
	              sumMatrix[r2][c1] + 
	              sumMatrix[r1][c1];
	  }

	  /**************/
	  /* Solution 3 */
	  /**************/
	  public static int findLargestSubmatrix3(int [][] matrix){	
		  int rowCount = matrix.length;
		  int colCount = matrix[0].length;
		  int [] partialSum = new int[colCount];
		  int maxSum = 0;	//max sum is an empty matrix
		  for (int r1 = 0; r1 < rowCount; r1++){
			  clearArray(partialSum);
			  for (int r2 = r1; r2 < rowCount; r2++){
				  for (int c = 0; c < colCount; c++){
					  partialSum[c] += matrix[r2][c];
				  }
				  /* If you want to track the coordinates, add code here to do that. */
				  int sum = maxSubArray(partialSum);
				  maxSum = Math.max(sum, maxSum);
			  }
		  }
		  return maxSum;
	  }
	  
	  public static int maxSubArray(int [] array){	//I coded this correctly on the 1st try.
		  int maxSum = 0;
		  int runningSum = 0;
		  for (int i = 0; i < array.length; i++){
			  runningSum += array[i];
			  maxSum = Math.max(maxSum, runningSum);
			  if (runningSum < 0)
				  runningSum = 0;
		  }
		  return maxSum;
	  }
	  
	  public static void clearArray(int [] array){
		  for (int i = 0; i < array.length; i++){
			  array[i] = 0;
		  }
	  }
}
