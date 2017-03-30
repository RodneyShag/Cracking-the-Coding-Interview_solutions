package chapter04;

/* Main Trick: Binary Search */
public class FourPoint3 {
	public static TreeNode createBST(int [] sortedArray) {
		if (sortedArray == null) {
			return null;
		}
		return createBST_Helper(sortedArray, 0, sortedArray.length - 1);
	}
	
	private static TreeNode createBST_Helper(int [] sortedArray, int startIndex, int endIndex) {
		if (startIndex > endIndex) {
			return null;
		}
		int mid = (startIndex + endIndex) / 2;
		TreeNode root = new TreeNode(sortedArray[mid]);
		root.left  = createBST_Helper(sortedArray, startIndex, mid - 1);
		root.right = createBST_Helper(sortedArray, mid + 1, endIndex);
		return root;
	}
}
