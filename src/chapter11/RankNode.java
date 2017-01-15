package chapter11;

public class RankNode {
	/* Standard "TreeNode" data */
	int data;
	RankNode left;
	RankNode right;
	
	/* Each node will keep track of the number of RankNodes in its left subtree (so that we don't have to do in-order traversal each time
	 * to figure it out */
	int leftSize = 0;
	
	public RankNode(int d){
		data = d;
	}
}
