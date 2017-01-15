package chapter4;

public class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	TreeNode parent = null;	//this is here so that 4.6 will work.
	
	public TreeNode(int data){
		this.data = data;
		left = null;
		right = null;
	}
}
