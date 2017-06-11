package common;

// Represents a binary Tree. If we wanted an n-ary tree,
// we would use an array of TreeNodes as children

public class TreeNode {
	public TreeNode left   = null;
	public TreeNode right  = null;
	public TreeNode parent = null;	// Needed for problem 4.6
	public int data;
	
	public TreeNode(int data) {
		this.data = data;
	}
	
	/* Useful for Problem 4.6 */
	public void addLeftChild(int data) {
		TreeNode node = new TreeNode(data);
		left = node;
		node.parent = this;
	}

	/* Useful for Problem 4.6 */
	public void addRightChild(int data) {
		TreeNode node = new TreeNode(data);
		right = node;
		node.parent = this;
	}

	@Override
	public String toString() {
		return String.valueOf(data) + " ";
	}
}
