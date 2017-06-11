package _10_10_Rank_from_Stream;

public class RankNode {
	int data;
	RankNode left;
	RankNode right;
	int leftSize; // each RankNode will keep track of the number of RankNodes in its left subtree

	public RankNode(int data) {
		this.data = data;
		left  = null;
		right = null;
		leftSize = 0;
	}
}
