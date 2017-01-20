package chapter4;

import java.util.ArrayList;

/* Big Trick: Instead of checking if a node starts a path that sums to "value", we check if it ENDS a path
 *            summing to "value".
 * 
 * Time/Space complexities: Assuming BALANCED binary tree
 * Time complexity: O(n log(n)) since we touch all "n" nodes and, findSum is O(log n)) in AVERAGE case.
 *                  findSum worst case is O((log n)^2) since it may call print every single time,
 *                  making overall time complexity worst case O(n log(n)^2)
 * Space complexity: O(log n) cuz that's the size of the array, and that's also the size of the number of recursive calls */
public class FourPoint9 {
	public static void findSum(TreeNode node, int value){
		ArrayList<TreeNode> path = new ArrayList<TreeNode>();
		findSum(node, value, path);
	}
	
	/* Recursive function */
	private static void findSum(TreeNode node, int value, ArrayList<TreeNode> path){
		if (node == null || path == null)
			return;
		path.add(node);
		checkSums(path, value);
		findSum(node.left,  value, path);
		findSum(node.right, value, path);
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
