// github.com/RodneyShag

package _10_10_Rank_from_Stream;

// Data Structures we could have used:
//
// Data Structure   Insert (into sorted structure)    getRank()
// ------------------------------------------------------------------------------------------
// Array            O(n) due to shifting              O(log n) using binary search
// Linked List      O(n)                              O(n) since we can't do binary search on linked list
// HashMap          O(1)                              O(n) since HashMap doesn't help us find rank in any way (it's not sorted)
// BST              O(log n) (if balanced tree)       O(log n) (if balanced tree)
//
// Note: Insert for array and linked list are O(n) since we insert into the position necessary to keep the data structure sorted

public class RankFromStream {

    private static RankNode root = null;

    // Called each time a number is generated
    public static void track(int x) {
        if (root == null) {
            root = new RankNode(x);
        } else {
            insert(x, root);
        }
    }

    private static void insert(int x, RankNode root) {
        RankNode curr = root;
        while (true) {
            if (x <= curr.data) {
                curr.leftSize++;
                if (curr.left == null) {
                    curr.left = new RankNode(x);
                    return;
                } else {
                    curr = curr.left;
                }
            } else {
                if (curr.right == null) {
                    curr.right = new RankNode(x);
                    return;
                } else {
                    curr = curr.right;
                }
            }
        }
    }

    // Returns number of values less than or equal to x (not including x itself)
    public static int getRankOfNumber(int x) {
        if (root == null) {
            return 0;
        }
        RankNode curr = root;
        int rank = 0;
        while (curr != null) {
            if (x == curr.data) {
                return rank + curr.leftSize;
            } else if (x > curr.data) {
                rank += 1 + curr.leftSize;
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        return 0;
    }
}
