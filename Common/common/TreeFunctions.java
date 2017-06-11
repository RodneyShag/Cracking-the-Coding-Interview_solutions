package common;

import java.util.ArrayDeque;

public class TreeFunctions {
	/* Creates and returns this Tree:
	 *          5
	 *        /   \
	 *       1    -3
	 *      /     / \
	 *     0     2   4
	 */
	public static TreeNode createTree() {
		TreeNode root = new TreeNode(5);
		root.addLeftChild(1);
		root.left.addLeftChild(0);
		root.addRightChild(-3);
		root.right.addLeftChild(2);
		root.right.addRightChild(4);
		return root;
	}
	
	/* Creates and returns this binary search tree:
	 *          5
	 *        /   \
	 *       1     8
	 *      /     / \
	 *     0     6   9
	 */
	public static TreeNode createBST() {
		TreeNode root = new TreeNode(5);
		root.addLeftChild(1);
		root.left.addLeftChild(0);
		root.addRightChild(8);
		root.right.addLeftChild(6);
		root.right.addRightChild(9);
		return root;
	}
	
	public static void printPreOrder(TreeNode node) {
		if (node != null) {
			System.out.print(node); // our toString() method will be invoked here
			printPreOrder(node.left);
			printPreOrder(node.right);
		}
	}
	
	public static void printInOrder(TreeNode node) {
		if (node != null) {
			printInOrder(node.left);
			System.out.print(node); // our toString() method will be invoked here
			printInOrder(node.right);
		}
	}
	
	public static void printPostOrder(TreeNode node) {
		if (node != null) {
			printPostOrder(node.left);
			printPostOrder(node.right);
			System.out.print(node); // our toString() method will be invoked here
		}
	}
	
	/* Prints tree level 0, 1, ... n */
	public static void printLevelOrder(TreeNode root) {
		ArrayDeque<TreeNode> deque = new ArrayDeque<>(); // use deque as a queue
		deque.addLast(root);
		while (!deque.isEmpty()) {
			TreeNode n = deque.remove();
			System.out.print(n + " ");
			if (n.left != null) {
				deque.addLast(n.left);
			}
			if (n.right != null) {
				deque.addLast(n.right);
			}
		}
	}
}
