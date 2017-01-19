package chapter4;

import java.util.ArrayList;

/* Solution 1: using int[]
 * Solution 2: using ArrayList<TreeNode>   (I prefer this method)
 * 
 * Big Trick: Instead of checking if a node starts a path that sums to "value", we check if it ENDS a path
 *            summing to "value".
 * 
 * Time/Space complexities: Assuming BALANCED binary tree
 * Time complexity: O(n log(n)) since we touch all "n" nodes and, findSum is O(log n)) in AVERAGE case.
 *                  findSum worst case is O((log n)^2) since it may call print every single time,
 *                  making overall time complexity worst case O(n log(n)^2)
 * Space complexity: O(log n) cuz that's the size of the array, and that's also the size of the number of recursive calls */
public class FourPoint9 {
	/**************/
	/* Solution 1 */
	/**************/
	public static void findSum(TreeNode treeNode, int value){
		int depth = depth(treeNode);
		int [] path = new int[depth];
		findSum(treeNode, value, path, 0);
	}
	
	private static void findSum(TreeNode treeNode, int value, int[] path, int level){
		if (treeNode == null)
			return;
		path[level] = treeNode.data;
		
		/* Print paths that END at this node */
		int currentSum = 0;
		for (int i = level; i >= 0; i--){		// notice we must go backwards with i--
			currentSum += path[i];
			if (currentSum == value)
				print(path, i, level);
		}
		
		findSum(treeNode.left, value, path, level + 1);
		findSum(treeNode.right, value, path, level + 1);
	}
	
	private static void print(int [] path, int start, int end){
		System.out.print("\nPath: ");
		for (int i = start; i <= end; i++){
			System.out.print(path[i] + " ");
		}
	}
	
	private static int depth(TreeNode treeNode){
		if (treeNode == null)
			return 0;
		return 1 + Math.max(depth(treeNode.left), depth(treeNode.right));
	}
	
	/**************/
	/* Solution 2 */
	/**************/
	public static void findSum2(TreeNode node, int value){
		ArrayList<TreeNode> path = new ArrayList<TreeNode>();
		findSum2(node, value, path);
	}
	
	/* Recursive function */
	private static void findSum2(TreeNode node, int value, ArrayList<TreeNode> path){
		if (node == null || path == null)
			return;
		path.add(node);
		checkSums(path, value);
		findSum2(node.left,  value, path);
		findSum2(node.right, value, path);
		path.remove(node);	// Important: notice we have 1 "remove" for each 1 "add"
	}
	
	/* We sum paths in REVERSE order to see if they equal 'value' */
	private static void checkSums(ArrayList<TreeNode> path, int value){
		if (path == null)
			return;
		int sum = 0;
		int lastIndex = path.size() - 1;
		for (int i = path.size() - 1; i >= 0; i--){ // Notice we must go backwards
			sum += path.get(i).data;
			if (sum == value)
				printPath(path, i, lastIndex);
		}
	}
	
	private static void printPath(ArrayList<TreeNode> path, int start, int end){
		System.out.println();
		for (int i = start; i <= end; i++){
			System.out.print(path.get(i).data + " ");
		}
	}	
}
