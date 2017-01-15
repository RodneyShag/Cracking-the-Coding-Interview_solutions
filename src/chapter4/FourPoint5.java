package chapter4;

public class FourPoint5 {
	/* Solution 1A - Inorder traversal should give numbers in increasing order
	 * - CAN'T HANDLE DUPLICATE ENTRIES CORRECTLY! They mention that themselves.
	 * - Saves tree into an array
	 * - Uses a static (global) variable to keep track of where to insert into the array. 
	 */
	
	/* Solution 1B - Same as Solution 1A, except without the array
	 * - CAN'T HANDLE DUPLICATE ENTRIES CORRECTLY! 
	 * - Uses a static variable to keep track of last item we visited\
	 */
	
	/* Solution 2 - Memorize Clever Trick!
	 * Great Solution. I needed the min/max idea hint from the book */
	public static boolean isBST(TreeNode root){
		return isBST_Helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean isBST_Helper(TreeNode root, int min, int max){
		if (root == null)
			return true;
		if (root.data <= min || root.data > max)	//Very common off-by-one errors for duplicates. Tricky whether it's <, <=, >, >=
			return false;
		return isBST_Helper(root.left, min, root.data) && isBST_Helper(root.right, root.data, max);
	}
}
