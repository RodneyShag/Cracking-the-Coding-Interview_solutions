package chapter04;

/* Read book's logic (but ignore its code). My code is much cleaner.
 * - Notice there are 2 distinct cases: "leftMostChild" (easy to code), "properParent" (a little tricky)
 */
public class FourPoint6 {
	public static TreeNode inOrderSucc(TreeNode treeNode) {
		if (treeNode == null) {
			return null;
		}
		
		if (treeNode.right != null) {
			return leftMostChild(treeNode.right);
		} else {
			return properParent(treeNode);
		}
	}
	
	private static TreeNode leftMostChild(TreeNode treeNode) {
		if (treeNode == null) {
			return null;
		}
		TreeNode result = treeNode;
		while (result.left != null) {
			result = result.left;
		}
		return result;
	}
	
	/* Finds the parent (well, ancestor) that has treeNode in its left subtree. Returns null if such a parent doesn't exist */
	private static TreeNode properParent(TreeNode treeNode) {
		if (treeNode == null) {
			return null;
		}
		TreeNode parent = treeNode.parent;
		TreeNode child  = treeNode;
		while (parent != null && parent.left != child) {
			child  = parent; // don't forget this crucial step
			parent = child.parent;
		}
		return parent;
	}
}
