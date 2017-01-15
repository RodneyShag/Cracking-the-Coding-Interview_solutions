package chapter11;
/* Code is from website. I altered it, which may have caused bugs. Algorithm is same as book's code */
public class ElevenPoint8 {
	
	private static RankNode root = null;	//it's weird that we have this here, but it's fine.
    
	static void insert(int v){		// which is the "track" function they wanted
		if (root == null)
			root = new RankNode(v);
		else
			insert(v, root);
	}
	
    static void insert(int v, RankNode node) {
        if (v > node.data) {
            if (node.right == null)
                node.right = new RankNode(v);
            else
                insert(v, node.right);
        }
        else {
            ++node.leftSize;
            if (node.left == null)
                node.left = new RankNode(v);
            else
                insert(v, node.left);
        }
    }
    
    static int getRank(int x) {				// which is the "getRankOfNumber" function they wanted
        return getRank(x, root);
    }
    
    static int getRank(int v, RankNode node) {
        if (node == null) 
        	return -1;
        if (v == node.data) {
            return node.leftSize;
        }
        else if (v > node.data) {
            int rightRank = getRank(v, node.right);
            if (rightRank == -1)						//remembering this is tricky.
            	return -1;
            else
            	return node.leftSize + 1 + rightRank;
        }
        else 
        	return getRank(v, node.left);
    }
}

/* My Notes:
 * Array:       Insert is O(n) cuz of shifting, getRank is O(log n) with a binary search of number
 * Linked List: Insert is O(n).                 getRank is O(n). (Notice WE CAN'T USE BINARY SEARCH ON A LINKED LIST. I was dumb and thought we could)
 * HashMap:     Insert is O(1).                 getRank is O(n) since the HashMap doesn't help us in any way. We still gotta look through all the #s
 * BST:         Insert is O(log n).             getRank is O(log n). THIS IS ONLY IF IT IS BALANCED. (My code doesn't balance it in any way)
 * 
 * (btw, for array and linked list, we would be inserting them into the proper place each time for it to always be sorted)
 */
