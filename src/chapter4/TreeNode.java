package chapter4;

public class TreeNode {
	TreeNode left   = null;
	TreeNode right  = null;
	TreeNode parent = null;	// Needed for problem 4.6
	int data;
	
	public TreeNode(int data){
		this.data = data;
	}
	
	/* Useful for Problem 4.6 */
	public void addLeftChild(int data){
		TreeNode node = new TreeNode(data);
		left = node;
		node.parent = this;
	}

	/* Useful for Problem 4.6 */
	public void addRightChild(int data){
		TreeNode node = new TreeNode(data);
		right = node;
		node.parent = this;
	}

	@Override
	public String toString(){
		return String.valueOf(data) + " ";
	}
}
