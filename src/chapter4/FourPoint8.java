package chapter4;

public class FourPoint8 {
	/* Solution 1 - Book's inorder/preorder traversal trick.
	 * T2's preorder traversal should be a substring of T1's preorder traversal. Same for inorder traversals (Need to insert dummy ")" for nulls
	 * Bad side: We make copies of both trees to create the 2 strings
	 */

	/**************/
	/* Solution 2 */	//I like coding this problem.
	/**************/
	/* Useful optimization: This function is here to do the initial (t2 == null) error check, so we dont need to do it every time recursively */
	public static boolean containsTree(TreeNode t1, TreeNode t2){
		if (t2 == null)
			return true;
		return subTree(t1, t2);
	}
	
	public static boolean subTree(TreeNode t1, TreeNode t2){
		if (t1 == null)
			return false;
		
		if (t1.data == t2.data){								//t2 will never be null since we checked it in "containsTree"
			if (matchTree(t1, t2))
				return true;
		}
		return subTree(t1.left, t2) || subTree(t1.right, t2);	//notice it's "t2", and not "t2.left" or "t2.right" which I messed up on once.
	}

	public static boolean matchTree(TreeNode p, TreeNode q){
		if (p == null && q == null)			//if (nothing left in each subtree)
			return true;					
		else if (p == null || q == null)	//if only one of them is null (since we did the && case above), then they do not match.
			return false;
		if (p.data != q.data)				//if (data doesn't match)
			return false;

		return matchTree(p.left, q.left) && matchTree(p.right, q.right);
	}
}
/* ----------Solution 1
 * Runtime: O(n + m)
 * Space  : O(n + m) since we copy the trees
 * 
 * ----------Solution 2
 * Runtime: O(nm) at worst case, but usually much better since the subtree won't match the tree in "matchTree", so it's O(n + km) where
 *          k is number of occurrences of T2's root in T1
 * Space Required: O(log(n) + log(m)). Which is great.
 */

/* Rodney's Solution 2 possible improvement: If we know height of smaller tree, we can only start searching nodes at the same height in bigger tree */

