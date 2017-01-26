package chapter11;

public class RankNode {
	int data;
	RankNode left  = null;
	RankNode right = null;
	int leftSize   = 0;    // each RankNode will keep track of the number of RankNodes in its left subtree
	
	public RankNode(int data){
		this.data = data;
	}
}
