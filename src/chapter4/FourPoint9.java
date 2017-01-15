package chapter4;
import java.util.ArrayList;

/* Update: Nowadays, I code this with ArrayList<TreeNode> (Solution 2) */
/* Time complexity: I think it's O(n log(n)) since we touch all "n" nodes and can possibly do a printPath on each of them (which is O(log n)) */
/* Space complexity (from book): O(log n) cuz that's the size of the array, and that's also the size of the number of recursive calls */
public class FourPoint9 {
	/**************/
	/* Solution 1 */	//using int[] (I don't like this version)
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
		for (int i = level; i >= 0; i--){		//notice we must go backwards with i--
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
	/* Solution 2 */	//using ArrayList<TreeNode>.  I like this version
	/**************/
	public static void findSum2(TreeNode node, int value){
		ArrayList<TreeNode> path = new ArrayList<TreeNode>();
		findSum2(node, value, path);
	}
	
	public static void findSum2(TreeNode node, int value, ArrayList<TreeNode> path){
		if (node == null || path == null)
			return;
		path.add(node);
		printSums(path, value);
		if (node.left != null)
			findSum2(node.left, value, path);
		if (node.right != null)
			findSum2(node.right, value, path);
		
		path.remove(node);	//Super Important: notice we have 1 "remove" for each 1 "add"
	}
	
	/* Coding this function is trivial */
	public static void printSums(ArrayList<TreeNode> path, int value){
		int sum = 0;
		for (int i = path.size() - 1; i >= 0; i--){
			sum += path.get(i).data;
			if (sum == value)
				System.out.print("\n" + sum);	//could also have printed out the actual path.
		}
	}
}
