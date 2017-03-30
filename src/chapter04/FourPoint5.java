package chapter04;

/* Checks if binary tree is binary search tree (BST)
 * 
 * Solutions               Runtime    Preference
 * ---------------------------------------------------
 * 1) Inorder Traversal    O(n)       Worth mentioning
 * 2) min/max idea         O(n)       Favorite
 */
public class FourPoint5 {
	/* Solution 1 - Inorder traversal should give numbers in increasing order
	 * - CAN'T HANDLE DUPLICATE ENTRIES CORRECTLY! They mention it in the book.
	 * - Saves tree into an array
	 * - Uses a global variable to keep track of where to insert into the array. 
	 */
	
	public static boolean isBST(TreeNode root) {
		return isBST_Helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private static boolean isBST_Helper(TreeNode node, int min, int max) {
		if (node == null) {
			return true;
		}
		if (node.data <= min || node.data > max) { // Very tricky off-by-one errors for duplicates. Tricky whether it's <, <=, >, >=
			return false;
		}
		return isBST_Helper(node.left, min, node.data) && isBST_Helper(node.right, node.data, max);
	}
}
