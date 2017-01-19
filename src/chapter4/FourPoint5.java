package chapter4;

/* I highly prefer Solution 2 */
public class FourPoint5 {
	/* Solution 1A - Inorder traversal should give numbers in increasing order
	 * - CAN'T HANDLE DUPLICATE ENTRIES CORRECTLY! They mention it in the book.
	 * - Saves tree into an array
	 * - Uses a global variable to keep track of where to insert into the array. 
	 */
	
	/* Solution 1B - Similar to Solution 1A, except without the array. Tricky to code.
	 * - CAN'T HANDLE DUPLICATE ENTRIES CORRECTLY!  They mention it in the book.
	 * - Uses a global variable to keep track of last item we visited
	 * - I think their solution has a bug. <= may have to be < on line 9 but I haven't thought it through
	 */
	
	/* Solution 2 - Clever Trick! I needed the min/max idea hint from the book */
	public static boolean isBST(TreeNode root){
		return isBST_Helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean isBST_Helper(TreeNode node, int min, int max){
		if (node == null)
			return true;
		if (node.data <= min || node.data > max)	//Very tricky off-by-one errors for duplicates. Tricky whether it's <, <=, >, >=
			return false;
		return isBST_Helper(node.left, min, node.data) && isBST_Helper(node.right, node.data, max);
	}
}
