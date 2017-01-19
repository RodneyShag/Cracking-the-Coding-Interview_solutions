package chapter4;

/* Read book's logic (but ignore its code). My code is much cleaner
 * - Notice there are 2 distinct cases: "leftMostChild" (easy to code), "properParent" (a little tricky)
 */
public class FourPoint6 {
	/* I read the logic of how to implement this. then coded it (mostly) correctly */
	public static TreeNode inOrderSucc(TreeNode treeNode){
		if (treeNode == null)
			return null;
		
		/* Case where it has a right subtree */
		if (treeNode.right != null)
			return leftMostChild(treeNode.right);
		/* Case where it doesn't have a right subtree */
		else
			return properParent(treeNode);
	}
	
	private static TreeNode leftMostChild(TreeNode treeNode){
		if (treeNode == null)
			return null;
		TreeNode result = treeNode;
		while(result.left != null){
			result = result.left;
		}
		return result;
	}
	
	/* Finds the parent (well, ancestor) that has treeNode in its left subtree. Returns null if such a parent doesn't exist */
	private static TreeNode properParent(TreeNode treeNode){
		if (treeNode == null)
			return null;
		TreeNode parent = treeNode.parent;
		TreeNode child  = treeNode;
		while(parent != null && parent.left != child){
			child = parent;			// i keep forgetting this crucial step
			parent = child.parent;
		}
		return parent;
	}
}
