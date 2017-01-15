package chapter4;

public class FourPoint7 {
	/* Book Solution 1: If we have links to parents, we can use those and mark nodes as "isVisited" */

	/**************/
	/* Solution 2 */ //O(n) runtime, but tricky to figure it out. From book explanation, and cuz 1 + 1/2 + 1/4 +... = constant.
	/**************/
	public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
		if (!covers(root, p) || !covers(root, q))
			return null;
		return commonAncestorHelper(root, p, q);
	}
	
	private static TreeNode commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q){
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
	
	/***************************************************************/
	/* This function is crucial. Used in solution 2 and solution 3 */
	/***************************************************************/
	private static boolean covers(TreeNode root, TreeNode node){
		/* Base Cases */
		if (root == null || node == null)
			return false;
		if (root == node)	//should not use "==". Should write a .isEquivalent or .equals in TreeNode class
			return true;
		
		/* Recursive Case */
		return covers(root.left, node) || covers(root.right, node);
	}
	
	
	/* Solution 3: SKIP IT. Their website code has Solution 2 instead. Solution 3 is more optimal, but harder algorithm and harder to code */
	/* Untested. Very likely I have minor bugs
	 * My version is different in that I first test to see if the tree "covers" the nodes
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