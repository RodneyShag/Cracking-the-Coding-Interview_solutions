package chapter4;

/* Find common ancestor
 * 
 * Solutions                  Runtime                     Preference
 * -----------------------------------------------------------------
 * 0) Trace Paths using BST   depends on if balanced      Clever
 * 1) Use links to parents    depends on if balanced      Clever
 * 2) Recursive               O(n)                        Favorite
 */
public class FourPoint7 {
	/* Book Solution 0: If Binary Search Tree, can trace paths (by saving them) of both nodes and see where they diverge */
	
	/* Book Solution 1: If we have links to parents, we can first save all of node1's parents (ancestors) in a HashMap
	 *                  and then see if node2's parents (ancestors) are any of those */

	/**************/
	/* Solution 2 */ 
	/**************/
	//O(n) runtime, but tricky to figure it out. Based off book: O(n)*(1 + 1/2 + 1/4 +...) = O(n)*(2) = O(n)
	public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
		if (!covers(root, p) || !covers(root, q))
			return null;
		return commonAncestorHelper(root, p, q);
	}
	
	private static TreeNode commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q){ // root will never be null here
		if (root == p || root == q)
			return root;
		
		boolean p_on_left = covers(root.left, p);
		boolean q_on_left = covers(root.left, q);
		
		if (p_on_left && q_on_left)
			return commonAncestorHelper(root.left, p, q);
		if (!p_on_left && !q_on_left)
			return commonAncestorHelper(root.right, p, q);
		else
			return root;	//since p and q are on different sides of root!
	}
	
	/* Helper function for solutions 2, 3: returns true if 'node' is in subtree of 'root', false otherwise */
	private static boolean covers(TreeNode root, TreeNode node){ // runs in O(n) since we gotta search all nodes.
		/* Base Cases */
		if (root == null || node == null)
			return false;
		if (root == node)
			return true;
		
		/* Recursive Case */
		return covers(root.left, node) || covers(root.right, node);
	}
}
