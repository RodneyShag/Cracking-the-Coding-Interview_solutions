package chapter4;

public class FourPoint1 {
	/* Solution 1 (Naive, slow runtime solution)
	 * It's O(n^2) because it's O(n) to check the height from a node, which we got to do for each of the n nodes, so n*n = n^2. 
	 * We have been recalculating the same heights over and over again. See other solution (below) to avoid this.
	 */
	public static boolean isBalanced(TreeNode root){
		if (root == null)
			return true;

		int leftTreeHeight = height(root.left);
		int rightTreeHeight = height(root.right);
		
		if (Math.abs(leftTreeHeight - rightTreeHeight) > 1) // this just checks if it's balanced at THIS node, not all nodes.
			return false;
		return isBalanced(root.left) && isBalanced(root.right);
	}
	
	private static int height(TreeNode root){
		if (root == null)
			return 0;
		else
			return 1 + Math.max(height(root.left), height(root.right));
	}
	
	/***************************************************************************************************************************/
	/* Solution 2 - Book O(n) time, O(h) space solution. Achieved by checking heights while we're checking if tree is balanced */
	/***************************************************************************************************************************/
	public static boolean isBalanced_2(TreeNode root){
		if (checkHeight(root) == -1)
			return false;
		else
			return true;
	}
	
	/* Returns -1 if unbalanced, otherwise returns height of tree from given node */
	private static int checkHeight(TreeNode root){
		if (root == null)
			return 0;	// height of 0. Crucial to return 0, and not -1.
		
		int leftHeight = checkHeight(root.left);
		int rightHeight = checkHeight(root.right);
		
		if (leftHeight == -1)
			return -1; // left tree is unbalanced
		if (rightHeight == -1)
			return -1; // right tree is unbalanced
		if (Math.abs(leftHeight - rightHeight) > 1)
			return -1; // imbalance between the 2 subtrees
		
		return 1 + Math.max(leftHeight, rightHeight);
	}
}
