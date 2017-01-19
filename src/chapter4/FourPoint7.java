package chapter4;

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
	
	
	/* Solution 3: SKIP IT. Way too difficult (for only a constant multiple speedup). Their website code has Solution 2 instead. 
	 * Untested. Very likely I have minor bug.  My version is different in that I first test to see if the tree "covers" the nodes.
	 */

	public static TreeNode commonAncestor3(TreeNode root, TreeNode p, TreeNode q){
		if (!covers(root, p) || !covers(root, q))
			return null;
		return commonAncestor3_Helper(root, p, q);
	}
	
	public static TreeNode commonAncestor3_Helper(TreeNode root, TreeNode p, TreeNode q){
		/* Return:
		 * 1) common ancestor of p and q if subtree contains p and q
		 * 2) p if subtree contains p but not q
		 * 3) q if subtree contains q but not p
		 * 4) null if subtree doesn't contain p or q
		 */
		if (root == null)
			return null;
		if (root == p || root == q)	//book does it differently here. I hope mine is correct.
			return root;

		TreeNode leftResult = commonAncestor3(root.left, p, q);
		if (leftResult != null && leftResult != p && leftResult != q) //common ancestor is in left subtree
			return leftResult;

		TreeNode rightResult = commonAncestor3(root.right, p, q);
		if (rightResult != null && rightResult != p && rightResult != q) //common ancestor is in right subtree
			return rightResult;

		if (leftResult != null && rightResult != null) // p and q are in different subtrees: root is common ancestor
			return root;
		
		if (leftResult == null && rightResult == null)
			return null;	// we checked earlier if the root is p or q
		
		/* At this point, one of either leftResult or rightResult is not null */
		return leftResult == null ? rightResult : leftResult;
	}
}
