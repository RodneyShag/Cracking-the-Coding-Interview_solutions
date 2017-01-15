package chapter4;
/* Read book's logic (but ignore its code). My code is much better
 * - Notice there are 2 distinct cases "leftMostChild" (easy to code) or "properParent" (a little tricky. Needs "isLeftChild" function. See below).
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
			return properParent(treeNode);	//my code is more legible than book's code. Even though it does the same thing.
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
	
	private static TreeNode properParent(TreeNode treeNode){
		if (treeNode == null)
			return null;
		TreeNode parent = treeNode.parent;
		while(parent != null && !isLeftChild(parent, treeNode)){
			treeNode = parent;			//i had forgotten this crucial step
			parent = treeNode.parent;
		}
		return parent;
	}
	
	private static boolean isLeftChild(TreeNode parent, TreeNode child){
		if (parent == null || child == null)
			return false;
		return (parent.left == child);
	}
}
