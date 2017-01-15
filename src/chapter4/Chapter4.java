package chapter4;

public class Chapter4 {
	public static void main(String [] args){
		//4.1 - No need to test. I just compared my code to the book
		//4.2 - Would have to implemented a Directed Graph, and proper Nodes, to test.
		
		/*** 4.3 ***/
		System.out.println("*** Test 4.3: BST from sorted array");
		int [] sortedArray = {1, 2, 3, 4, 5, 6, 7};
		TreeNode BST = FourPoint3.createBST(sortedArray);
		System.out.print("In-Order print of tree: ");
		FourPoint3.inOrderPrint(BST);
		
		//4.4 - My solution is same as book code. Too lazy to test.
		//4.5 - My solution is same as book code. Too lazy to test.
		//4.6 - My solution is same as book code. Too lazy to test.
		//4.7 - My solution is same as book code. Too lazy to test.
		//4.8 - My solution is same as book code. Too lazy to test.
		
		/*** 4.9 ***/
		System.out.print("\n\n*** Test 4.9: Tree paths summing to value");
		TreeNode n = new TreeNode(4);
		n.left = new TreeNode(1);
		n.left.left = new TreeNode(0);
		n.right = new TreeNode(-1);
		n.right.left = new TreeNode(2);
		n.right.right = new TreeNode(4);
		
		FourPoint9.findSum(n, 5);
		
		System.out.print("\n\nSolution version 2");
		FourPoint9.findSum2(n, 5);
		
		
	}
}
