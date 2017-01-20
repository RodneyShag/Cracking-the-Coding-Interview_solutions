package chapter4;

import java.util.ArrayList;
import java.util.LinkedList;

public class Chapter4 {
	public static void main(String [] args){
		test_DFS();
		test_BFS();
		test_PrintPreOrder();
		test_PrintInOrder();
		test_PrintPostOrder();
		test_PrintLevelOrder();
		test_FourPoint1();
		test_FourPoint2();
		test_FourPoint3();
		test_FourPoint4();
		test_FourPoint5();
		test_FourPoint6();
		test_FourPoint7();
		test_FourPoint8();
		test_FourPoint9();
	}
	
	public static void test_DFS(){
		GraphNode graphNode = GraphFunctions.createGraph();
		System.out.println("\n*** Test DFS");
		GraphFunctions.DFS(graphNode, 6); // searches for value 6
	}
	
	public static void test_BFS(){
		GraphNode graphNode = GraphFunctions.createGraph();
		System.out.println("\n*** Test BFS");
		GraphFunctions.DFS(graphNode, 6); // searches for value 6
	}
		
	public static void test_PrintPreOrder(){
		TreeNode tree = TreeFunctions.createBST();
		System.out.println("\n*** Test print (pre-order)");
		TreeFunctions.printPreOrder(tree);
	}
	
	public static void test_PrintInOrder(){
		TreeNode tree = TreeFunctions.createBST();
		System.out.println("\n\n*** Test print (in-order)");
		TreeFunctions.printInOrder(tree);
	}
	
	public static void test_PrintPostOrder(){
		TreeNode tree = TreeFunctions.createBST();
		System.out.println("\n\n*** Test print (post-order)");
		TreeFunctions.printPostOrder(tree);
	}
	
	public static void test_PrintLevelOrder(){
		TreeNode tree = TreeFunctions.createBST();
		System.out.println("\n\n*** Test print (level-order)");
		TreeFunctions.printLevelOrder(tree);
	}
	
	public static void test_FourPoint1(){
		TreeNode tree = TreeFunctions.createBST();
		System.out.println("\n\n*** Test 4.1: (Balanced Trees)");
		System.out.println("(Solution 1) Is balanced? " + FourPoint1.isBalanced(tree));
		System.out.println("(Solution 2) Is balanced? " + FourPoint1.isBalanced_2(tree));
	}

	/* Testing is not thorough, I just do a simple test */
	public static void test_FourPoint2(){
		System.out.println("\n*** Test 4.2: Route exists");
		GraphNode node1 = new GraphNode(1);
		GraphNode node2 = new GraphNode(2);
		node1.addNeighbor(node2);
		System.out.println("Route exists? (should be true): " + FourPoint2.routeExists(node1, node2));
	}
	
	public static void test_FourPoint3(){
		System.out.println("\n*** Test 4.3: BST from sorted array");
		int [] sortedArray = {1, 2, 3, 4, 5, 6, 7};
		TreeNode BST = FourPoint3.createBST(sortedArray);
		System.out.print("In-Order print of tree: ");
		TreeFunctions.printInOrder(BST);
	}
	
	public static void test_FourPoint4(){
		TreeNode tree = TreeFunctions.createBST();
		System.out.println("\n\n*** Test 4.4: create lists by level");
		ArrayList<LinkedList<TreeNode>> lists = FourPoint4.createLinkedLists(tree);
		for (LinkedList<TreeNode> list : lists){
			System.out.print("\nNew level ");
			for (TreeNode node : list){
				System.out.print(node);
			}
		}
	}
	
	public static void test_FourPoint5(){
		TreeNode tree1 = TreeFunctions.createTree();
		TreeNode tree2 = TreeFunctions.createBST();
		System.out.println("\n\n*** Test 4.5: is BST?");
		System.out.println("Should be false: " + FourPoint5.isBST(tree1));
		System.out.println("Should be true: " + FourPoint5.isBST(tree2));
	}
	
	public static void test_FourPoint6(){
		TreeNode tree = TreeFunctions.createBST();
		System.out.println("\n*** Test 4.6: Find inOrderSucc");
		System.out.println("Should be 6: " + FourPoint6.inOrderSucc(tree));
		System.out.println("Should be 5: " + FourPoint6.inOrderSucc(tree.left));
		System.out.println("Should be null: " + FourPoint6.inOrderSucc(tree.right.right));
	}
	
	public static void test_FourPoint7(){
		TreeNode tree = TreeFunctions.createBST();
		System.out.println("\n*** Test 4.7: Common ancestor");		
		System.out.println("Common ancestor should be 5: " + FourPoint7.commonAncestor(tree, tree.left, tree.right.right));
		System.out.println("Common ancestor should be 8: " + FourPoint7.commonAncestor(tree, tree.right, tree.right.left));
	}
	
	public static void test_FourPoint8(){
		TreeNode tree1 = TreeFunctions.createTree();
		TreeNode tree2 = TreeFunctions.createBST();
		System.out.println("\n*** Test 4.8: subTree");
		System.out.println("Should be false: " + FourPoint8.containsTree(tree1, tree2));
	}
	
	public static void test_FourPoint9(){
		System.out.print("\n*** Test 4.9: Tree paths summing to value");
		TreeNode tree = TreeFunctions.createBST();		
		FourPoint9.findSum(tree, 6);
	}
}
