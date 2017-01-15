package chapter4;

/* Main Trick: Binary Search
 * I did this all on my own (1st time through book). Worked perfectly. (I had to look up binary search though, as a quick refresher */
public class FourPoint3 {
	public static TreeNode createBST(int [] sortedArray){
		if (sortedArray == null)
			return null;
		return createBST_Helper(sortedArray, 0, sortedArray.length - 1);
	}
	
	/* Simple Binary Search: I always seem to code this without errors */
	private static TreeNode createBST_Helper(int [] sortedArray, int startIndex, int endIndex){
		if (startIndex > endIndex)
			return null;
		int mid = (startIndex + endIndex) / 2;
		TreeNode root = new TreeNode(sortedArray[mid]);
		root.left = createBST_Helper(sortedArray, startIndex, mid - 1);
		root.right = createBST_Helper(sortedArray, mid + 1, endIndex);
		return root;
	}
	
	/* This is here to check my result */
	public static void inOrderPrint(TreeNode root){
		if (root == null)
			return;
		inOrderPrint(root.left);
		System.out.print(root.data + " ");
		inOrderPrint(root.right);
	}
	
}
