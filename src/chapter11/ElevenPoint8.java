package chapter11;

/* Data Structures we could have used:
 * 
 *              Insert (into sorted structure)     getRank()
 * ------------------------------------------------------------------------------------------
 * Array:       O(n) cuz of shifting               O(log n) using binary search
 * Linked List: O(n).                              O(n) since we can't do binary search on linked list
 * HashMap:     O(1).                              O(n) since HashMap doesn't help us find rank in any way (it's not sorted)
 * BST:         O(log n).                          O(log n) (assuming it's balanced)
 * 
 * Note: Insert for array and linked list are O(n) since we insert into the position necessary to keep the data structure sorted
 */
public class ElevenPoint8 {
	
	private static RankNode root = null;
	
	/* Called each time a number is generated */
	public static void track(int x) {
		if (root == null) {
			root = new RankNode(x);
		} else {
			insert(x, root);
		}
	}
	
	private static void insert(int x, RankNode node) {
		if (x <= node.data) {
			node.leftSize++;
			if (node.left == null) {
				node.left = new RankNode(x);
			} else {
				insert(x, node.left);
			}
		} else {
			if (node.right == null) {
				node.right = new RankNode(x);
			} else {
				insert(x, node.right);
			}
		}
	}
	
	/* Returns number of values less than or equal to x (not including x itself) */
	public static int getRankOfNumber(int x) {
		if (root == null) {
			return 0;
		}
		return getRankOfNumber(x, root);
	}
	
	private static int getRankOfNumber(int x, RankNode node) {
		if (node == null) {
			return 0;
		} else if (x == node.data) {
			return node.leftSize;
		} else if (x > node.data) {
			return 1 + node.leftSize + getRankOfNumber(x, node.right);
		} else {
			return getRankOfNumber(x, node.left);
		}
	}
}
