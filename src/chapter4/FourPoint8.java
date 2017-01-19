package chapter4;

public class FourPoint8 {
	/* Solution 1
	 * - Book says if T1's preorder traversal is substring of T2's preorder traversal, and same is true for inorder traversals,
	 *   then they T2 is substring of T1
	 * - Book further says to insert dummy "0" for nulls. This is necessary to distinguish the 2 trees in book with duplicate values.
	 * - However, I believe that if we do this "dummy 0" trick, then just checking preorder traversals should suffice
	 *   instead of having to also check inorder traversals.
	 * - Bad space complexity: We make copies of both trees to create the 2 strings
	 */

	/**************/
	/* Solution 2 */
	/**************/
	public static boolean containsTree(TreeNode t1, TreeNode t2){
		if (t2 == null)  // the empty tree is always a subtree. We do this check here to avoid doing it every time in subTree
			return true;
		return subTree(t1, t2);
	}
	
	public static boolean subTree(TreeNode t1, TreeNode t2){
		if (t1 == null)
			return false;
		
		if (t1.data == t2.data){
			if (matchTree(t1, t2))
				return true;
		}
		return subTree(t1.left, t2) || subTree(t1.right, t2);
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
/* Runtimes: 
 * Let t1 have n nodes and t2 have m nodes
 * 
 * ----------Solution 1
 * Runtime: O(n + m)
 * Space  : O(n + m) since we copy the trees
 * 
 * ----------Solution 2
 * Runtime: O(nm) at worst case, but average case is much better since matchTree() usually wont be called often, 
 * so it's O(n + km) where k is number of occurrences of T2's root in T1
 * - Also, even when we do call matchTree, it is likely to not match very soon in its search
 * Space Required: O(log(n) + log(m)). Which is great.
 */
