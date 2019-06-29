package _4_11_Random_Node;

class BST {
    Node root = null;
    RandomizedCollection<Node> collection = new RandomizedCollection<>();

    public void insert(int value) {
        Node item = new Node(value);
        
        // Update collection
        collection.add(item);

        // Update tree
        if (root == null) {
            root = item;
            return;
        }
        Node curr = root;
        while (true) {
            if (value <= curr.value) {
                if (curr.left == null) {
                    curr.left = item;
                    return;
                } else {
                    curr = curr.left;
                }
            } else {
                if (curr.right == null) {
                    curr.right = item;
                    return;
                } else {
                    curr = curr.right;
                }
            }
        }
    }

    public Node find(int value) {
        Node curr = root;
        while (curr != null) {
            if (value == curr.value) {
                return curr;
            } else if (value < curr.value) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return null;
    }

    public Node getRandomNode() {
        return collection.getRandom();
    }
    
    // delete() not coded
    //
    // - To delete, can find "inorder successor" from node to delete, and put that in deleted node's spot
    // - For "Inorder Successor" code, see Cracking the Coding Interview question 4.6
    // - For Deletion, see 1-3 at: https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
}

// Time Complexity: O(1) for getRandomNode()