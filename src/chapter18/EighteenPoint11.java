package chapter18;
/* Code is from website. It is O(n^4)
 * Book also has "preprocessed" O(n^3) algorithm that made sense.
 * - I practiced coding both and did well. Memorizing the concept is the most important part. 
 */
public class EighteenPoint11 {
	//  Suppose black is 1, white is 0.
	
	  static Result findLargestSubsquare(int[][] matrix) {
	      for (int len = matrix.length; len >= 2; --len) {
	          Result res = findSubsquare(matrix, len);
	          if (res != null) 
	        	  return res;
	      }
	      return null;
	  }
	  
	  /* This function is VERY IMPORTANT */
	  static Result findSubsquare(int[][] matrix, int length) {
	      int cnt = matrix.length - length + 1;
	      for (int i = 0; i < cnt; ++i) {
	          for (int j = 0; j < cnt; ++j) {
	              if (isValid(matrix, i, j, length)) {
	                  return new Result(i, j, length);
	              }
	          }
	      }
	      return null;
	  }
	  
	  /* This function I would be able to code on my own...no problem (but my code would be slightly different) */
	  static boolean isValid(int[][] m, int r, int c, int l) {
	      for (int n = 0; n < l; n++) {
	          //check top and bottom rows
	          if (m[r][c+n] == 0 || m[r+l-1][c+n] == 0)
	              return false;
	          //check left and right columns
	          if (m[r+n][c] == 0 || m[r+n][c+l-1] == 0)
	              return false;
	      }
	      return true;
	  }
	  
	  static class Result {
	      int col; int row; int length;
	      public Result(int r, int c, int l) {row=r;col=c;length=l;}
	  }
}
